package com.sample.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import({WebPageSecurityConfig.class, WebServiceSecurityConfig.class})
public class SecurityConfig{
	
}
