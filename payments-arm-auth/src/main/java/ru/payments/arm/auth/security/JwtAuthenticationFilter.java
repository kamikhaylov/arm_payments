package ru.payments.arm.auth.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.payments.arm.auth.model.User;
import ru.payments.arm.auth.service.AuthorizationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

/**
 * Фильтр аутентификации
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; /* 10 days */
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String SIGN_UP_URL = "/payments-arm/registration/signUp";
    public static final String REDIRECT_URL = "/redirect/**";

    private final AuthenticationManager auth;
    private final AuthorizationService authorizationService;

    public JwtAuthenticationFilter(AuthenticationManager auth, AuthorizationService authorizationService) {
        this.auth = auth;
        this.authorizationService = authorizationService;
    }

    /** Проверка логина и пароля пользователя */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            User user = new ObjectMapper()
                                   .readValue(req.getInputStream(), User.class);

            return auth.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getLogin(),
                            user.getPassword(),
                            authorizationService.findAuthorities(user.getLogin()))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Создание токена */
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = JWT.create()
                               .withSubject(((org.springframework.security.core.userdetails.User)
                                                     auth.getPrincipal()).getUsername())
                               .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                               .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_AUTHORIZATION, TOKEN_PREFIX + token);
    }
}
