package com.springweb.web.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springweb.web.system.System;
import com.springweb.web.system.WebUtil;

@Controller
public class SystemController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexPage(Map<String, Object> map) {		
		Collection<GrantedAuthority> grantedAuthority = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return getHomePage( map, grantedAuthority );
	}	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView raizPage(Map<String, Object> map) {		
		Collection<GrantedAuthority> grantedAuthority = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return getHomePage( map, grantedAuthority );
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView homePage(Map<String, Object> map) {	
		Collection<GrantedAuthority> grantedAuthority = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return getHomePage( map, grantedAuthority );
	}	
	
	/*******   SPRING-SECURITY   *********************/
	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login");
	}
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public ModelAndView successLogin(Map<String, Object> map) {
		Collection<GrantedAuthority> grantedAuthority = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return getHomePage( map, grantedAuthority );
	}
	
	private ModelAndView getHomePage(Map<String, Object> map, Collection<GrantedAuthority> grantedAuthority){
		ModelAndView modelAndView = new ModelAndView("login");
		String role = "";
		if( WebUtil.isRolePresent( grantedAuthority, System.ROLE_ADMIN ) ){
			role = System.ROLE_ADMIN;
			modelAndView = new ModelAndView("homeAdmin");
		}else if( WebUtil.isRolePresent( grantedAuthority, System.ROLE_USER ) ){
			role = System.ROLE_USER;
			modelAndView = new ModelAndView("homeUser");
		}else if( WebUtil.isRolePresent( grantedAuthority, System.ROLE_ADMINISTRADOR_TARIFAS ) ){
			role = System.ROLE_ADMINISTRADOR_TARIFAS;
			modelAndView = new ModelAndView("homeAdministradorTarifas");
		}		
		map.put("role", role);
		return modelAndView;
	}	
	
}