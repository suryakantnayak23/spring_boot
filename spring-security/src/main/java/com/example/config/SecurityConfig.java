//package com.example.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//
//		http.csrf(csrf->csrf.disable());
//
//		http.authorizeHttpRequests(request->request
//											.anyRequest()
//											.authenticated());//any request will be authenticated
//
////		http.formLogin(Customizer.withDefaults());
//
//		http.httpBasic(Customizer.withDefaults());
//
//		http.sessionManagement(session->session
//										.sessionCreationPolicy
//										(SessionCreationPolicy.STATELESS));// to make the session stateless
//
//		return http.build();// to return modified security filter chain object
//	}
//
//	@Bean
//	public UserDetailsService detailsService() {
//
//		UserDetails obj1 = User.withDefaultPasswordEncoder()
//								.username("biswajit")
//								.password("3213").roles("USER").build();
//
//
//		UserDetails obj2 = User.withDefaultPasswordEncoder()
//								.username("Surya")
//								.password("76543").roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(obj1,obj2);// its a class and its constructor takes multiple UserDetails object
//	}
//
//}
