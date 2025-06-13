package com.my.sts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// index는 모두 접근 가능, hello는 로그인으로 접속
		// login은 접근 가능, logout도 접근 가능
		//http.csrf().disable() -> csrf (듀플리케이드 예정)
//		http.cors(cors->cors.disable());
//		http.httpBasic(basic->basic.disable()); -> API서비스로만 처리할 때 사용(view사용X)
		
		//h2 접속 위한 일시적 허용
		http.csrf(config->config.disable());	//form 태그
		http.authorizeHttpRequests(req->req.requestMatchers("/h2/**").permitAll())
			.headers().frameOptions().sameOrigin();
		
		http
			//접근의 관리
			.authorizeHttpRequests((requests) -> requests
//				.requestMatchers("/", "/home","/ex02").permitAll()
//				.anyRequest().authenticated()
				.requestMatchers("/hello").authenticated()
				.requestMatchers("/ex01").hasAuthority("ADMIN")
				.requestMatchers("/ex02").hasAuthority("USER")
				.requestMatchers("/ex03").hasAnyAuthority("USER")
				.requestMatchers("/ex04").hasAnyAuthority("ADMIN","USER")
				.anyRequest().permitAll()
			)
//			.formLogin(Customizer.withDefaults())
//			.logout(Customizer.withDefaults());
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
	
		return http.build();
	}
	
	//단방향 암호화(encoding만 가능)
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 인증, 인가
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
////			 User.withDefaultPasswordEncoder()
//			 User.withUsername("scott")
////				.username("scott")
////			 	.password("$2a$10$w79Q1IJN1DRvkqNwB2GbyutJkasVPMs.8WNzv3W6i/OuJG5QtbwqK")
//				.password(passwordEncoder().encode("tiger"))
//				.roles("USER")
//				.build();
//		
//		String code=passwordEncoder().encode("tiger");
//		System.out.println(code);
//		System.out.println(passwordEncoder().matches("tiger", code));
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
