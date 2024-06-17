package com.hemanth.springthings.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class BasicAuthHandlerInterceptor implements HandlerInterceptor {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    /*NAME
    Authorization
    VALUE
    Basic YWRtaW46YWRtaW4=
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("BasicAuthHandlerInterceptor::preHandle()");
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Basic ")){
            String base64Creds = authHeader.substring("Basic ".length());
            byte[] decodedCreds = Base64.getDecoder().decode(base64Creds);
            String creds = new String(decodedCreds, StandardCharsets.UTF_8); // admin:admin
            String[] parts = creds.split(":");
            String username = parts[0];
            String password = parts[1];

            if (USERNAME.equals(username) && PASSWORD.equals(password)){
                return true;
            }
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("BasicAuthHandlerInterceptor::postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("BasicAuthHandlerInterceptor::afterCompletion()");
    }
}
