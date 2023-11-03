package ru.payments.arm.auth.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.payments.arm.auth.model.Authority;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.model.UserAuthorities;
import ru.payments.arm.logger.exception.PaymentException;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0004;
import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0005;
import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0006;
import static ru.payments.arm.auth.logging.AuthLogEvent.AUTH0007;

/**
 * Реализация интерфейса взаимодействия с таблицими users и authorities
 */
@Primary
@Repository
@AllArgsConstructor
public class AuthDaoImpl implements AuthDao {

    private final UserCrudDao userCrudDao;
    private final AuthorityCrudDao authorityCrudDao;
    private final UserAuthoritiesCrudDao userAuthoritiesCrudDao;

    public Optional<User> findByLogin(String login) {
        try {
            return userCrudDao.findByLogin(login);
        } catch (Exception ex) {
            throw new PaymentException(AUTH0004, login);
        }
    }

    public Optional<User> findByEmail(String email) {
        try {
            return userCrudDao.findByEmail(email);
        } catch (Exception ex) {
            throw new PaymentException(AUTH0005, email);

        }
    }

    public Optional<Authority> findByAuthority(String authority) {
        try {
            return authorityCrudDao.findByAuthority(authority);
        } catch (Exception ex) {
            throw new PaymentException(AUTH0006, authority);
        }
    }

    @Transactional
    public void save(User user) {
        try {
            userCrudDao.save(user);
        } catch (Exception ex) {
            throw new PaymentException(AUTH0007, ex, user.getLogin());
        }
    }

    @Override
    public Set<UserAuthorities> findUserAuthoritiesByUserId(Integer userId) {
        return userAuthoritiesCrudDao.findAllByUserId(userId);
    }

    @Override
    public Set<Authority> findAuthorityByIdList(Set<Integer> ids) {
        return authorityCrudDao.findByIdList(ids);
    }
}
