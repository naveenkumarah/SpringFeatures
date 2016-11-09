package com.sample.security.config;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
@Order(200)
@EnableWebSecurity
public class WebPageSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication().passwordEncoder(md5PasswordEncoder).dataSource(dataSource);
	  	  
	  //auth.inMemoryAuthentication().withUser("naveen").password("naveen").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatcher(new RequestMatcher() {
           public boolean matches(final HttpServletRequest request) {
                final String url = request.getServletPath() + request.getPathInfo();
                return !(url.startsWith("/services/"));
            }
		});
		
		
		//http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
		http.authorizeRequests()
		.antMatchers("/").permitAll() 
		.antMatchers("/user/**").access("hasRole('ADMIN')")
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/accessDenied.jsp")
		.and().logout().deleteCookies("JSESSIONID").logoutUrl("/logout.do").logoutSuccessUrl("/login.jsp")
		.and().csrf().disable();
	
	  	
		
	}


}
