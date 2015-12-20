package com.sample.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.sample.dao.config.HibernateConfiguration;
import com.sample.mvc.controller.CORSFilter;
import com.sample.security.config.SecurityConfig;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.sample.mvc.controller","com.sample.rest.controller","com.sample.jaxrs.service"})
@Import({ SecurityConfig.class,CORSFilter.class,HibernateConfiguration.class})
@ImportResource({"classpath:applicationContext-common-business.xml","classpath:application-ws.xml"})
public class AppConfig extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver 
                          = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
