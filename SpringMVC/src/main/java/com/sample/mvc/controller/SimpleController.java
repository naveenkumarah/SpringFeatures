package com.sample.mvc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.mvc.pojo.Person;

@Controller
public class SimpleController {
	private final Logger logger = LoggerFactory.getLogger(SimpleController.class);
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login() {
		logger.info("Login Controller");
		return new ModelAndView("login","person",new Person());
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("person") Person person,BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
	            return new ModelAndView("login");
	        }
		logger.info("Authentication Controller"+"user name:"+person.getUsername());
		return new ModelAndView("loginSuccess");
	}
	
	//@Secured({ "ROLE_ADMIN" })
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/secure/list.do", method = RequestMethod.GET)
	public ModelAndView studentDisplay() {
		logger.info("Result Controller");
		return new ModelAndView("result");
	}
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login.jsp";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
