package com.onlineshop.onlineshop.web.filter;

import com.onlineshop.onlineshop.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");

        String path =request.getServletPath();
        if (!"/login".equals(path) && !"/register".equals(path) && !"/main.css".equals(path) && user==null) {
            response.sendRedirect("/login");
        }
        else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
