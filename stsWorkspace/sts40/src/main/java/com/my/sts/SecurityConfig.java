package com.my.sts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.my.sts.service.JwtService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	JwtService jwtService() {
		return new JwtService();
	}
	
	@Bean
	TokenFilter tokenFilter(JwtService jwtService) {
		return new TokenFilter(jwtService);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf->csrf.disable())
		.httpBasic(custom->custom.disable())
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/", "/login").permitAll()
			.anyRequest().authenticated()
		)
		.sessionManagement(manager->{
			manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		})
		//session 사용 안 함
		.addFilterBefore(tokenFilter(jwtService()), UsernamePasswordAuthenticationFilter.class)
		;
//		.formLogin((form) -> form
//			.loginPage("/login")
//			.permitAll()
//		)
//		.logout((logout) -> logout.permitAll());

	return http.build();

	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user=User.withDefaultPasswordEncoder()
				.username("user01")
				.password("1234")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
