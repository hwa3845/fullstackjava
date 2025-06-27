package com.sts.sts39.config;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.sts.sts39.service.JwtService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtFilter implements Filter {
    // @Autowired
    final JwtService service;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String[] ignores={"/","/login"};
        HttpServletRequest req=(HttpServletRequest)request;
        if(req.getRequestURI().equals("/")){
            chain.doFilter(request, response);
            return;
        }
        if(req.getRequestURI().equals("/login")){
            chain.doFilter(request, response);
            return;
        }
        String auth=req.getHeader("Authorization");
        System.out.println(auth);
        if(auth!=null && auth.startsWith("Bearer ")){
            String id=service.verify(auth.substring("Bearer ".length()));
            chain.doFilter(request, response);
            return;
        }
        //if()
        // 
        throw new UnsupportedOperationException("Unimplemented method 'doFilter'");
    }
    
}
