package com.gonzalo.challenge.techforb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gonzalo.challenge.techforb.security.JWTAuthenticationFilter;
import com.gonzalo.challenge.techforb.security.JWTAuthorizationFilter;


@Configuration
public class SecurityConfig{
	
	private final UserDetailsService userDetailsService;
	
	private final JWTAuthorizationFilter jwtAuthorizationFilter;
	
	public SecurityConfig(@Autowired UserDetailsService userDetailsService, @Autowired JWTAuthorizationFilter jwtAuthorizationFilter) {
		this.userDetailsService = userDetailsService;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");		
		
		return http
				.csrf()
				.disable()
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter,UsernamePasswordAuthenticationFilter.class)
				.logout().permitAll()
				.and()
				.build();
	}
//	
//	@Bean
//	UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(
//				User.
//				withUsername("admin")
//				.password(passwordEncoder().encode("admin"))
//				.roles()
//				.build()
//				);
//		return manager;
//	}
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception{
		return http
		.getSharedObject(AuthenticationManagerBuilder.class)
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder())
		.and()
		.build();
	}
		

}