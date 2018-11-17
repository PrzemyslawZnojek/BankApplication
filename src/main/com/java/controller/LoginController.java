package main.com.java.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage(){
		
		return "logging-view";
	}

	@RequestMapping("/success")
	public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

		String role =  authResult.getAuthorities().toString();

		if(role.contains("ROLE_USER")){
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user/panel"));
		}else if(role.contains("ROLE_EMPLOYEE")) {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/customer/list"));
		}
	}
	
}
