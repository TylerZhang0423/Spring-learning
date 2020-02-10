package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "userFilter", urlPatterns = "/*")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---------------------->>>init 初始化");
    }

    @Override
    public void destroy() {
        System.out.println("---------------------->>>destory 释放");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---------------------->>>doFilter 过滤");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
