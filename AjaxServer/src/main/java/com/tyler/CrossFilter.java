package com.tyler;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-29 17:35
 */
public class CrossFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        res.addHeader("Access-Control-Allow-Methods", "GET");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
