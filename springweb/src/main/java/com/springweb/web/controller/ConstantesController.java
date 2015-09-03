package com.springweb.web.controller;

import java.util.Collection;
import java.util.Map;

import org.commons.util.LoggerFacUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springweb.web.entity.User;
import com.springweb.web.service.ConstanteService;
import com.springweb.web.service.RutaService;
import com.springweb.web.service.RutaspricehistoryService;
import com.springweb.web.service.RutaspricehistorydetailService;
import com.springweb.web.service.UserService;
import com.springweb.web.service.VariableService;
import com.springweb.web.system.System;
import com.springweb.web.system.WebUtil;

@Controller
public class ConstantesController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ConstanteService constanteService;
	
	@Autowired
	RutaService rutaService;
	
	@Autowired
	RutaspricehistorydetailService rutaspricehistorydetailService;
	
	@Autowired
	RutaspricehistoryService rutaspricehistoryService;
	
	@Autowired
	VariableService variableService;
	
	@RequestMapping(value="/tarifario/getConstantes", method=RequestMethod.GET)
	public String getConstantes(Map<String, Object> map){
		try{	
			String userName = WebUtil.getUserNameFromAuthentication();
			User objUser = new User();
			objUser = userService.getUserByCondition( " WHERE u.login = '"+ userName + "'" );
			/** DATOS PAGINA **/
			String role = WebUtil.getMainRole();		
			map.put("role", role);		
			/** DATOS PAGINA **/			
		}catch( Exception ex ){	
			LoggerFacUtil.error(this.getClass().getName(), ex," addEditConstante() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
			return "error";				
		}	
		return "error";
	}	

	@RequestMapping(value="/tarifario/addEditConstante", method=RequestMethod.POST)
	public String addEditConstante(Map<String, Object> map, 
			@ModelAttribute("rutaService") RutaService rutaService){
		try{			
			String userName = WebUtil.getUserNameFromAuthentication();
			User objUser = new User();
			objUser = userService.getUserByCondition( " WHERE u.login = '"+ userName + "'" );
			/** DATOS PAGINA **/
			String role = WebUtil.getMainRole();		
			map.put("role", role);		
			/** DATOS PAGINA **/
			return "tarifario/getConstantes";		
		}catch( Exception ex ){
			LoggerFacUtil.error(this.getClass().getName(), ex," addEditConstante() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
			return "error";			
		}
	}
	
}