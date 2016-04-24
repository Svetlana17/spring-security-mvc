package com.bytestree.web.handler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bytestree.model.Users;
import com.bytestree.service.UserService;

@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		User loginUser = (User) authentication.getPrincipal();

		Users user = userService.getUser(loginUser.getUsername());
		user.setFailedLogins(0);
		user.setLastLoginDate(new Date());
		userService.saveUser(user);

		response.sendRedirect("home");
	}

}
