package ru.payments.arm.auth.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.payments.arm.auth.service.AuthorizationService;
import ru.payments.arm.auth.utlis.TokenUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static ru.payments.arm.auth.security.JwtAuthenticationFilter.HEADER_AUTHORIZATION;
import static ru.payments.arm.auth.security.JwtAuthenticationFilter.TOKEN_PREFIX;

/**
 * Фильтр авторизации
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final AuthorizationService authorizationService;

    public JwtAuthorizationFilter(AuthenticationManager authManager, AuthorizationService authorizationService) {
        super(authManager);
        this.authorizationService = authorizationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_AUTHORIZATION);

        if (isNull(header) || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_AUTHORIZATION);
        if (nonNull(token)) {
            /* parse the token. */
            String login = TokenUtils.getLogin(token);

            if (nonNull(login)) {
                return new UsernamePasswordAuthenticationToken(login, null, authorizationService.findAuthorities(login));
            }
            return null;
        }
        return null;
    }
}
