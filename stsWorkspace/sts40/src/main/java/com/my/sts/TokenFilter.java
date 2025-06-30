package com.my.sts;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.my.sts.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {

	final JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//filter로부터 값 꺼내기 단, 로그인 정보가 있을 때는 필터 적용 안 돼야 함
		String[] ignores= {"/","/login"};
		if(Stream.of(ignores).anyMatch(ignore->ignore.equals(request.getRequestURI()))) {
			filterChain.doFilter(request, response);			
			return;
		}
		String auth=request.getHeader("Authorization");
		
		if(auth==null||!auth.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		String token=auth=auth.substring("Bearer ".length());
		
		System.out.println("필터 수행 전");
		jwtService.parseInfo(token);
		//spring security의 filter 내부에 들어와있는 상태이기 때문에 SecurityContext 받기 가능
		SecurityContext ctxt=SecurityContextHolder.getContext();
		ctxt.setAuthentication(
				new UsernamePasswordAuthenticationToken(
						"user01",null,List.of(new SimpleGrantedAuthority("USER"))));
		filterChain.doFilter(request, response);
		System.out.println("필터 수행 후");
	}

}
