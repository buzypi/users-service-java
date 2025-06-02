package com.jnaapti.usersservice;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class RequestLoggingFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, jakarta.servlet.ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    Collections.list(req.getHeaderNames())
        .forEach(headerName -> System.out.println(headerName + ": " + req.getHeader(headerName)));
    chain.doFilter(request, response);
  }
}
