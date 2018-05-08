package main.com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role =  authResult.getAuthorities().toString();

        int i = 2;
        if(i == 1){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/customer/list"));                            
        }else if(i == 2) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user/panel"));
            }
       }
    
}
