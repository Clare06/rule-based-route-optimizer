package com.example.rulebasedrouteoptimization.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Autowired
    public JwtTokenInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Get the JWT token from the request header
        String token = request.getHeader("Authorization");
        System.out.println(token + " " + " recieved token");
        // Validate the token
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove the "Bearer " prefix
            try {
                //Verify the token and extract the claims
                Claims claims = jwtUtil.extractAllClaims(token);

                System.out.println(claims);
                return true;
//        }
            } catch (ExpiredJwtException ex) {
                // Token has expired, handle it appropriately
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            } catch (Exception ex) {
                // Token validation failed, handle it appropriately
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }


        }
        // Token is invalid or not present, return an unauthorized response
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
