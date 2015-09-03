package com.springweb.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.commons.util.LoggerFacUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springweb.web.entity.User;
import com.springweb.web.entity.tarifario.Variable;
import com.springweb.web.service.ConstanteService;
import com.springweb.web.service.RutaService;
import com.springweb.web.service.RutaspricehistoryService;
import com.springweb.web.service.RutaspricehistorydetailService;
import com.springweb.web.service.UserService;
import com.springweb.web.service.VariableService;
import com.springweb.web.system.System;
import com.springweb.web.system.WebUtil;

@Controller
public class VariablesController {
	
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
	
	@RequestMapping(value="/tarifario/getVariables", method=RequestMethod.GET)
	public String getVariables(Map<String, Object> map){
		try{	
			String userName = WebUtil.getUserNameFromAuthentication();
			User objUser = new User();
			objUser = userService.getUserByCondition( " WHERE u.login = '"+ userName + "'" );	
			/** DATOS PAGINA **/
			String role = WebUtil.getMainRole();		
			map.put("role", role);		
			/** DATOS PAGINA **/				
		}catch( Exception ex ){	
			LoggerFacUtil.error(this.getClass().getName(), ex," addEditVariable() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
			return "error";				
		}	
		return "error";
	}	

	@RequestMapping(value="/tarifario/addEditVariable", method=RequestMethod.POST)
	public String addEditVariable(Map<String, Object> map, 
			@ModelAttribute("variable") Variable variable){
		try{			
			String userName = WebUtil.getUserNameFromAuthentication();
			User objUser = new User();
			objUser = userService.getUserByCondition( " WHERE u.login = '"+ userName + "'" );	
			/** DATOS PAGINA **/
			String role = WebUtil.getMainRole();		
			map.put("role", role);		
			/** DATOS PAGINA **/	
			if ( variable.getId() == null ){	
				List<Variable> variableList = new ArrayList<Variable>();
				String conditionV = " WHERE v.description = '"+variable.getDescription()+"' ";
				variableList = variableService.listVariableByCondition(conditionV);
				if ( variableList == null ){
					variableService.addVariable(variable);
				}else{
					map.put("status", System.SISTEMA_ERROR );
					map.put("mensaje", "Este dato ya existe. No se guardo" );				
					return "error";						
				}
			}else{
				List<Variable> variableList = new ArrayList<Variable>();
				String conditionV = " WHERE v.id != "+variable.getId()+" "+
						" v.description = '"+variable.getDescription()+"' ";
				variableList = variableService.listVariableByCondition(conditionV);
				if ( variableList == null ){
					variableService.editVariable(variable);
				}else{
					map.put("status", System.SISTEMA_ERROR );
					map.put("mensaje", "Este dato ya existe. No se modifico" );				
					return "error";						
				}				
			}
			return "tarifario/getVariables";		
		}catch( Exception ex ){
			LoggerFacUtil.error(this.getClass().getName(), ex," addEditVariable() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
			return "error";			
		}
	}
	
}