package applicSpring.config;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {

        // Map<String,String> roleTargetUrlMap = new HashMap<>();
   // roleTargetUrlMap.put("ROLE_USER", "/user.html")
    // Spring Security использует объект Authentication, пользователя авторизованной сессии.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        //if (roles.contains("ADMIN")) {
        if (roles.contains("ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
        }
       // if (roles.contains("ROLE_USER")) {
        if (roles.contains("USER")) {
            httpServletResponse.sendRedirect("/user");
        } else {
            httpServletResponse.sendRedirect("/");
        }


       /* UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        if (user.isOTPRequired()) {
            customerService.clearOTP(customer);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

        */

    }


}


