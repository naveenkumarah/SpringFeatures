package com.sample.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CXFInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		 // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
 
        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(AppConfig.class);
             
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
		
		ServletRegistration.Dynamic registration = container.addServlet("cxf", new CXFServlet());
        registration.setLoadOnStartup(2);
        registration.addMapping("/services/*");
		
	}

}
