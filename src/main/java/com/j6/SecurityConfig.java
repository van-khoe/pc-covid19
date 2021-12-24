package com.j6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.j6.service.UserService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserService userService;
	@Bean
	public BCryptPasswordEncoder gettPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/khaibaoyte","/lichsutiem","/lichsukhaibao","/lichhentiemchung","/dangkytiemchung","/nhacnhotiemchung","/taikhoan/**").authenticated()
		.antMatchers("/admin/**","/assets/admin/**").hasAnyRole("PM","ADMIN")
		.antMatchers("/rest/authorities").hasRole("ADMIN")
		.anyRequest().permitAll();
		
		http.exceptionHandling()
		.accessDeniedPage("/security/unauthoried");
		

		
		http.formLogin()
		.loginPage("/home")
		.loginProcessingUrl("/security/dangnhap")
		.defaultSuccessUrl("/home", false)
		.failureUrl("/home");

		
		http.rememberMe()
		.tokenValiditySeconds(86400);
		
		http.logout()
		.logoutUrl("/security/dangxuat")
		.logoutSuccessUrl("/home");
		
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
