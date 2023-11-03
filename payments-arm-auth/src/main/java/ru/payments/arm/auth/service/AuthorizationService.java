package ru.payments.arm.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.payments.arm.auth.dao.AuthDao;
import ru.payments.arm.auth.model.Authority;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.model.UserAuthorities;
import ru.payments.arm.logger.exception.PaymentException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0001;
import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0002;
import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0003;
import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0008;
import static ru.payments.arm.auth.model.Authorities.VIEW_PAYMENTS;

/**
 * Сервис авторизации
 */
@Service
@AllArgsConstructor
public class AuthorizationService implements UserDetailsService {

    private static final String ROLE_PREFIX = "ROLE_";

    private final AuthDao authDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = authDao.findByLogin(login);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(login);
        }
        return new org.springframework.security.core.userdetails.User(
                user.get().getLogin(),
                user.get().getPassword(),
                findAuthorities(user.get()));
    }

    public void createUser(User user) {
        try {
            Optional<User> userFound = authDao.findByLogin(user.getLogin());
            if (userFound.isPresent()) {
                throw new PaymentException(AUTH0001, user.getLogin());
            }
            userFound = authDao.findByEmail(user.getEmail());
            if (userFound.isPresent()) {
                throw new PaymentException(AUTH0002, user.getEmail());
            }
            Optional<Authority> defaultAuthority = authDao.findByAuthority(VIEW_PAYMENTS);
            if (defaultAuthority.isEmpty()) {
                throw new PaymentException(AUTH0003, user.getEmail());
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(true);
            user.setAuthorities(Set.of(defaultAuthority.get()));
            authDao.save(user);
        } catch (PaymentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new PaymentException(AUTH0008, user.getLogin());
        }
    }

    public User findUser(String login) {
        Optional<User> user = authDao.findByLogin(login);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(login);
        }
        return user.get();
    }

    public List<SimpleGrantedAuthority> findAuthorities(User user) {
        Set<UserAuthorities> userAuthorities = authDao.findUserAuthoritiesByUserId(user.getId());
        Set<Integer> authorityIds = new HashSet<>();
        for (UserAuthorities userAuthority : userAuthorities) {
            authorityIds.add(userAuthority.getAuthorityId());
        }
        user.setAuthorities(authDao.findAuthorityByIdList(authorityIds));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : user.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + authority.getAuthority()));
        }

        return authorities;
    }

    public List<SimpleGrantedAuthority> findAuthorities(String login) {
        return findAuthorities(findUser(login));
    }
}
