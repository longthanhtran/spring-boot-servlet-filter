package com.example.filter.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyFilter implements Filter {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);
    
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Starting in init ..");
    }
    
    @Override
    public void doFilter(final ServletRequest request, 
            final ServletResponse response, 
            final FilterChain chain) 
            throws IOException, ServletException {
        LOGGER.info("Server Name is: " + request.getServerName());
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
        LOGGER.warn("Now stopping the filter ...");
    }
    
}
