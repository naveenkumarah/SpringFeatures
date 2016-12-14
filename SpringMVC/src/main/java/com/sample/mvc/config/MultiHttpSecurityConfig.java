package com.sample.mvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;

@EnableWebSecurity
public class MultiHttpSecurityConfig {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication().passwordEncoder(md5PasswordEncoder).dataSource(dataSource);
	}
	

	@Configuration
	@Order(1)                                                        
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/services/**")                               
				.authorizeRequests()
					.anyRequest().hasRole("ADMIN")
					.and()
				.httpBasic();
			//.and().addFilter(new DigestAuthenticationFilter()).exceptionHandling().authenticationEntryPoint(wsAuthenticationEntryPoint())
			//.and().csrf().disable();
	
		}
	}
		 @Bean
		    public DigestAuthenticationEntryPoint wsAuthenticationEntryPoint() {
		        final DigestAuthenticationEntryPoint wsAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
		        wsAuthenticationEntryPoint.setRealmName("Realm via Digest Authentication");
		        wsAuthenticationEntryPoint.setKey("webservice");
		        wsAuthenticationEntryPoint.setNonceValiditySeconds(10);
		        return wsAuthenticationEntryPoint;
		    }

	@Configuration                                                   
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.anyRequest().authenticated()
					.and()
				.formLogin();
		}
	}
}