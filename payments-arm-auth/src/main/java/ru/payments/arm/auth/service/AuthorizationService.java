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
import ru.payments.arm.logger.exception.PaymentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptyList;
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
                emptyList());
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
}
