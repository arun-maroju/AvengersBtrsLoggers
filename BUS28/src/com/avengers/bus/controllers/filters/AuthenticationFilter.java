package com.avengers.bus.controllers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Still Working on it

@WebFilter("/passengers")
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("In filter..");
		// Initialization logic, if needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("IN do filter.. method..");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		// Allow access to login and logout pages without authentication
		if (path.equals("/login") || path.equals("/logout")) {

			System.out.println("IN do filter.. method.. if block1");

			chain.doFilter(request, response);
			return;
		}

		// Check if user is authenticated
		if (httpRequest.getSession().getAttribute("authenticatedUser") != null) {

			System.out.println("IN do filter.. method.. if block2");

			// User is authenticated, allow access to requested page
			chain.doFilter(request, response);
		} else {
			System.out.println("IN do filter.. method.. if block2 else block");

			// User is not authenticated, redirect to login page
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
		}
	}

	@Override
	public void destroy() {
		System.out.println("Filter destroy..");
		// Cleanup resources, if needed
	}
}
