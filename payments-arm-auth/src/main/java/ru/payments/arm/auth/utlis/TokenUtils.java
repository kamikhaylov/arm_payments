package ru.payments.arm.auth.utlis;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import static ru.payments.arm.auth.security.JwtAuthenticationFilter.SECRET;
import static ru.payments.arm.auth.security.JwtAuthenticationFilter.TOKEN_PREFIX;

public final class TokenUtils {

    private TokenUtils() {
    }

    public static String getLogin(String token) {
        return JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                       .build()
                       .verify(token.replace(TOKEN_PREFIX, ""))
                       .getSubject();
    }
}
