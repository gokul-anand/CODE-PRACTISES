package com.visa.prj.web;

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
import javax.servlet.http.HttpSession;

@WebFilter("*.jsp")
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession ses = req.getSession();
		System.out.println(req.getRequestURI());
		
		if(ses!=null && ses.getAttribute("user")!=null) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("login.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
