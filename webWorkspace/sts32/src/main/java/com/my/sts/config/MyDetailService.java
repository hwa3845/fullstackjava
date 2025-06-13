package com.my.sts.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.my.sts.model.AuthsRepo;
import com.my.sts.model.EmpRepo;
import com.my.sts.model.entity.Emp;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyDetailService implements UserDetailsService {
//	private final EmpRepo empRepo;
//	private final AuthsRepo authsRepo;
//	private final BCryptPasswordEncoder encoder;
	private final SqlSessionTemplate session;
		
	// UserDetailsService를 상속하고 bean 객체가 되게 만듦
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Emp> opt=empRepo.findByName(username);
		Emp emp=session.getMapper(EmpRepo.class).findByName(username);
		String code="";
//		if(opt.isPresent()) {
//			code=opt.get().getPw();
//		}
//		System.out.println(code);
//		System.out.println(code.length());
		List<SimpleGrantedAuthority> auths=null;
		auths=session.getMapper(AuthsRepo.class).findByName(username).stream()
				.map(auth->new SimpleGrantedAuthority(auth.getAuth())).toList();
		
//		auths=authsRepo.findByName(username).stream()
//		.map(auth->new SimpleGrantedAuthority(auth.getAuth()))
//		.toList()
		
//		authsRepo.findByName(username).forEach(auth->{
//			auths.add(new SimpleGrantedAuthority(auth.getAuth()));
//		});
		
		return User.withUsername(username)
				.password(code)
//				.roles("USER")
				.authorities(auths)
				.build();
	}

}
