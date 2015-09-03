package com.springweb.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.commons.util.LoggerFacUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springweb.web.entity.User;
import com.springweb.web.entity.tarifario.Rutaspricehistory;
import com.springweb.web.entity.tarifario.Ruta;
import com.springweb.web.entity.tarifario.Rutaspricehistorydetail;
import com.springweb.web.service.ConstanteService;
import com.springweb.web.service.RutaService;
import com.springweb.web.service.RutaspricehistoryService;
import com.springweb.web.service.RutaspricehistorydetailService;
import com.springweb.web.service.UserService;
import com.springweb.web.service.VariableService;
import com.springweb.web.system.System;
import com.springweb.web.system.WebUtil;

@Controller
public class TarifarioController {
	
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
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}		
	
	@RequestMapping(value="/tarifario/getTarifas", method=RequestMethod.GET)
	public String getTarifas(Map<String, Object> map){
		try{	
			List<Rutaspricehistory> listRutaspricehistory = new ArrayList<Rutaspricehistory>();
			String condition = " WHERE rph.datecreated = ( SELECT MAX(rph2.datecreated) from Rutaspricehistory rph2 WHERE rph.ruta.id=rph2.ruta.id ) "+
					" ORDER BY rph.datecreated DESC ";
			listRutaspricehistory = rutaspricehistoryService.listRutaspricehistoryByCondition(condition);
			map.put("rutaspricehistoryList", listRutaspricehistory);
			Rutaspricehistory rutaspricehistory = new Rutaspricehistory();
			float costoCombustible = constanteService.getConstanteByCondition(" WHERE c.description = 'COSTO COMBUSTIBLE' ").getValue();			
			float mttokm = constanteService.getConstanteByCondition(" WHERE c.description = 'MTTO/KM(VARIABLE)' ").getValue();		
			float backupmexico = constanteService.getConstanteByCondition(" WHERE c.description = 'BACK UP MEXICO' ").getValue();		
			float fee = constanteService.getConstanteByCondition(" WHERE c.description = 'FEE' ").getValue();		
			float jornadaLaboralForaneo = constanteService.getConstanteByCondition(" WHERE c.description = 'JORNADA LABORAL FORANEO' ").getValue();		
			float jornadaLaboralLocal = constanteService.getConstanteByCondition(" WHERE c.description = 'JORNADA LABORAL LOCAL' ").getValue();			
			float viajes = constanteService.getConstanteByCondition(" WHERE c.description = 'VIAJES' ").getValue();		
			float ayudantesXViaje = constanteService.getConstanteByCondition(" WHERE c.description = 'AYUDANTES X VIAJES' ").getValue();
			rutaspricehistory.setCostoCombustible(costoCombustible);
			rutaspricehistory.setMttokm(mttokm);
			rutaspricehistory.setBackupmexico(backupmexico);
			rutaspricehistory.setFee(fee);
			rutaspricehistory.setJornadaLaboralForaneo(jornadaLaboralForaneo);
			rutaspricehistory.setJornadaLaboralLocal(jornadaLaboralLocal);
			rutaspricehistory.setViajes(viajes);
			rutaspricehistory.setViajes(viajes);
			rutaspricehistory.setAyudantesXViaje(ayudantesXViaje);
			map.put("attributeRutaspricehistory", rutaspricehistory );
			map.put("rutaspricehistory", new Rutaspricehistory() );			
			return "tarifario/tarifas";
		}catch( Exception ex ){	
			LoggerFacUtil.error(this.getClass().getName(), ex," getTarifas() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
		}	
		return "error";
	}
	
	@RequestMapping(value="/tarifario/getTarifasDetail/{rutaspricehistoryID}", method=RequestMethod.GET)
	public String getTarifasDetail(Map<String, Object> map,
			@PathVariable("rutaspricehistoryID")Integer id){
		try{		
			Rutaspricehistory rutaspricehistory = rutaspricehistoryService.getRutaspricehistory(id);
			float costoCombustible = constanteService.getConstanteByCondition(" WHERE c.description = 'COSTO COMBUSTIBLE' ").getValue();			
			float mttokm = constanteService.getConstanteByCondition(" WHERE c.description = 'MTTO/KM(VARIABLE)' ").getValue();		
			float backupmexico = constanteService.getConstanteByCondition(" WHERE c.description = 'BACK UP MEXICO' ").getValue();		
			float fee = constanteService.getConstanteByCondition(" WHERE c.description = 'FEE' ").getValue();		
			float jornadaLaboralForaneo = constanteService.getConstanteByCondition(" WHERE c.description = 'JORNADA LABORAL FORANEO' ").getValue();		
			float jornadaLaboralLocal = constanteService.getConstanteByCondition(" WHERE c.description = 'JORNADA LABORAL LOCAL' ").getValue();			
			float viajes = constanteService.getConstanteByCondition(" WHERE c.description = 'VIAJES' ").getValue();		
			float ayudantesXViaje = constanteService.getConstanteByCondition(" WHERE c.description = 'AYUDANTES X VIAJES' ").getValue();
			rutaspricehistory.setCostoCombustible(costoCombustible);
			rutaspricehistory.setMttokm(mttokm);
			rutaspricehistory.setBackupmexico(backupmexico);
			rutaspricehistory.setFee(fee);
			rutaspricehistory.setJornadaLaboralForaneo(jornadaLaboralForaneo);
			rutaspricehistory.setJornadaLaboralLocal(jornadaLaboralLocal);
			rutaspricehistory.setViajes(viajes);
			rutaspricehistory.setViajes(viajes);
			rutaspricehistory.setAyudantesXViaje(ayudantesXViaje);
			map.put("attributeRutaspricehistory", rutaspricehistory );
			Rutaspricehistorydetail rutaspricehistorydetail = rutaspricehistorydetailService.getRutaspricehistorydetail(id);
			map.put("attributeRutaspricehistorydetail", rutaspricehistorydetail );				
			map.put("rutaspricehistory", new Rutaspricehistory() );
			List<Rutaspricehistory> listRutaspricehistory = new ArrayList<Rutaspricehistory>();
			String condition = " WHERE rph.ruta.id="+rutaspricehistory.getRuta().getId()+" ORDER BY rph.datecreated DESC ";
			listRutaspricehistory = rutaspricehistoryService.listRutaspricehistoryByCondition(condition);
			map.put("rutaspricehistoryList", listRutaspricehistory);				
			return "tarifario/tarifa_detail";
		}catch( Exception ex ){	
			LoggerFacUtil.error(this.getClass().getName(), ex," getTarifasDetail() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
		}	
		return "error";
	}	
	
	@RequestMapping(value="/tarifario/showTarifasDetail/{rutaspricehistoryID}", method=RequestMethod.GET)
	public String showTarifasDetail(Map<String, Object> map,
			@PathVariable("rutaspricehistoryID")Integer id){
		try{		
			Rutaspricehistory rutaspricehistory = rutaspricehistoryService.getRutaspricehistory(id);
			map.put("attributeRutaspricehistory", rutaspricehistory );
			Rutaspricehistorydetail rutaspricehistorydetail = rutaspricehistorydetailService.getRutaspricehistorydetail(id);
			map.put("attributeRutaspricehistorydetail", rutaspricehistorydetail );			
			map.put("rutaspricehistory", new Rutaspricehistory() );				
			return "tarifario/tarifa_showDetail";
		}catch( Exception ex ){	
			LoggerFacUtil.error(this.getClass().getName(), ex," getTarifasDetail() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
		}	
		return "error";
	}	

	@RequestMapping(value="/tarifario/addTarifaPost", method=RequestMethod.POST)
	public String addTarifaPost(Map<String, Object> map, 
			@ModelAttribute("rutaspricehistory") Rutaspricehistory rutaspricehistory){
		try{			
			String userName = WebUtil.getUserNameFromAuthentication();
			User objUser = new User();
			objUser = userService.getUserByCondition( " WHERE u.name = '"+ userName + "'" );
			List<Ruta> listRuta = new ArrayList<Ruta>();
			String condition = " WHERE r.description = '"+rutaspricehistory.getRuta().getDescription()+"' ";
			listRuta = rutaService.listRutaByCondition(condition);
			if ( listRuta == null ){
				Date fechaActual = WebUtil.getFechaHoraActual();
				Ruta ruta = new Ruta();
				ruta.setDescription( rutaspricehistory.getRuta().getDescription() );
				ruta.setDatecreated( fechaActual );
				ruta.setDatemodified(fechaActual );
				ruta.setUser(objUser);
				rutaService.addRuta(ruta);
				
				Rutaspricehistory objRutaspricehistory= new Rutaspricehistory();	
				objRutaspricehistory.setIdestatus(1);
				objRutaspricehistory.setDatecreated(fechaActual);
				objRutaspricehistory.setDatemodified(fechaActual);
				objRutaspricehistory.setRuta(ruta);
				
				Rutaspricehistorydetail rutaspricehistorydetail = new Rutaspricehistorydetail();
				float fuel = rutaspricehistory.getRutaspricehistorydetail().getFuel();
				float mttokm = rutaspricehistory.getRutaspricehistorydetail().getMttokm();
				float backupmexico = rutaspricehistory.getRutaspricehistorydetail().getBackupmexico();
				float fee = rutaspricehistory.getRutaspricehistorydetail().getFee();
				float foreingworkday = rutaspricehistory.getRutaspricehistorydetail().getForeingworkday();
				float localworkday = rutaspricehistory.getRutaspricehistorydetail().getLocalworkday();
				float travels = rutaspricehistory.getRutaspricehistorydetail().getTravels();
				float kmtravel = rutaspricehistory.getRutaspricehistorydetail().getKmtravel();
				float cycletyme = rutaspricehistory.getRutaspricehistorydetail().getCycletyme();		
				float cycletimeassistant = rutaspricehistory.getRutaspricehistorydetail().getCycletimeassistant();
				float yielditskm = rutaspricehistory.getRutaspricehistorydetail().getYielditskm();
				float assistanttravel = rutaspricehistory.getRutaspricehistorydetail().getAssistanttravel();
				float avgsalaryoperator = rutaspricehistory.getRutaspricehistorydetail().getAvgsalaryoperator();
				float avgsalaryassistant = rutaspricehistory.getRutaspricehistorydetail().getAvgsalaryassistant();
				float pasivelaboroperator = rutaspricehistory.getRutaspricehistorydetail().getPasivelaboroperator();
				float pasivelaborassistant = rutaspricehistory.getRutaspricehistorydetail().getAvgsalaryassistant();
				float expensestravel = (float) (((travels*cycletyme)/(localworkday*4.34)) * (1+backupmexico));
				float realoperators = (expensestravel/expensestravel)*expensestravel;//REVISAR FORMULA
				float assistants = realoperators;
				float totalworkforce = ((realoperators*avgsalaryoperator)+(avgsalaryassistant*assistants))*(1+fee);
				float totalfuel = ((travels*kmtravel)/yielditskm)*fuel;
				float totalmtto = travels*kmtravel*mttokm;
				float totalexpensestravel = 0*(1+fee)*travels;
				float price = (totalworkforce+totalfuel+totalmtto+totalexpensestravel)/travels;
				float incrementtotalworkforce = totalworkforce*(1+5);
				float incrementtotalfuel = totalfuel*(1+8);
				float incrementtotalmtto = totalmtto*(1+9);
				float incrementtotalexpensestravel = totalexpensestravel*(1+4);
				rutaspricehistorydetail.setFuel(fuel);
				rutaspricehistorydetail.setMttokm(mttokm);
				rutaspricehistorydetail.setBackupmexico(backupmexico);
				rutaspricehistorydetail.setFee(fee);
				rutaspricehistorydetail.setLocalworkday(localworkday);
				rutaspricehistorydetail.setTravels(travels);
				rutaspricehistorydetail.setKmtravel(kmtravel);
				rutaspricehistorydetail.setCycletyme(cycletyme);
				rutaspricehistorydetail.setYielditskm(yielditskm);
				rutaspricehistorydetail.setAvgsalaryoperator(avgsalaryoperator);
				rutaspricehistorydetail.setAvgsalaryassistant(avgsalaryassistant);
				rutaspricehistorydetail.setExpensestravel(expensestravel);
				rutaspricehistorydetail.setRealoperators(realoperators);
				rutaspricehistorydetail.setAssistants(assistants);
				rutaspricehistorydetail.setTotalworkforce(totalworkforce);
				rutaspricehistorydetail.setTotalfuel(totalfuel);
				rutaspricehistorydetail.setTotalmtto(totalmtto);
				rutaspricehistorydetail.setTotalexpensestravel(totalexpensestravel);
				rutaspricehistorydetail.setPrice(price);
				//rutaspricehistorydetail.setIncrementtotalworkforce(incrementtotalworkforce);
				//rutaspricehistorydetail.setIncrementtotalfuel(incrementtotalfuel);
				//rutaspricehistorydetail.setIncrementtotalmtto(incrementtotalmtto);
				//rutaspricehistorydetail.setIncrementtotalexpensestravel(incrementtotalexpensestravel);
				//rutaspricehistorydetail.setDatecreated( fechaActual );
				//rutaspricehistorydetail.setDatemodified(fechaActual );	
				objRutaspricehistory.setPrice(price);
				objRutaspricehistory.setRutaspricehistorydetail(rutaspricehistorydetail);
				rutaspricehistorydetail.setRutaspricehistory(objRutaspricehistory);
				
				rutaspricehistoryService.addRutaspricehistory(objRutaspricehistory);
				return "redirect:/tarifario/getTarifas";	
			}
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", "La ruta ya existe." );				
			return "error";					
		}catch( Exception ex ){
			LoggerFacUtil.error(this.getClass().getName(), ex," tarifaPost() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
			return "error";			
		}
	}

	@RequestMapping(value="/tarifario/editTarifaPost", method=RequestMethod.POST)
	public String editTarifaPost(Map<String, Object> map, 
			@ModelAttribute("rutaspricehistory") Rutaspricehistory rutaspricehistory){
		try{			
			String userName = WebUtil.getUserNameFromAuthentication();
			User objUser = new User();
			objUser = userService.getUserByCondition( " WHERE u.name = '"+ userName + "'" );
			Ruta ruta = new Ruta();
			ruta = rutaService.getRuta( rutaspricehistory.getRuta().getId() );
			if ( ruta != null ){
				Date fechaActual = WebUtil.getFechaHoraActual();
				ruta.setDescription( rutaspricehistory.getRuta().getDescription() );
				ruta.setDatemodified(fechaActual );
				ruta.setUser(objUser);
				rutaService.editRuta(ruta);
				
				Rutaspricehistory objRutaspricehistory= new Rutaspricehistory();			
				objRutaspricehistory.setPrice( rutaspricehistory.getPrice() );
				objRutaspricehistory.setIdestatus(1);
				objRutaspricehistory.setDatecreated(fechaActual);
				objRutaspricehistory.setDatemodified(fechaActual);
				objRutaspricehistory.setRuta(ruta);
				
				Rutaspricehistorydetail rutaspricehistorydetail = new Rutaspricehistorydetail();
				float fuel = rutaspricehistory.getRutaspricehistorydetail().getFuel();
				float mttokm = rutaspricehistory.getRutaspricehistorydetail().getMttokm();
				float backupmexico = rutaspricehistory.getRutaspricehistorydetail().getBackupmexico();
				float fee = rutaspricehistory.getRutaspricehistorydetail().getFee();
				float foreingworkday = rutaspricehistory.getRutaspricehistorydetail().getForeingworkday();
				float localworkday = rutaspricehistory.getRutaspricehistorydetail().getLocalworkday();
				float travels = rutaspricehistory.getRutaspricehistorydetail().getTravels();
				float kmtravel = rutaspricehistory.getRutaspricehistorydetail().getKmtravel();
				float cycletyme = rutaspricehistory.getRutaspricehistorydetail().getCycletyme();		
				float cycletimeassistant = rutaspricehistory.getRutaspricehistorydetail().getCycletimeassistant();
				float yielditskm = rutaspricehistory.getRutaspricehistorydetail().getYielditskm();
				float assistanttravel = rutaspricehistory.getRutaspricehistorydetail().getAssistanttravel();
				float avgsalaryoperator = rutaspricehistory.getRutaspricehistorydetail().getAvgsalaryoperator();
				float avgsalaryassistant = rutaspricehistory.getRutaspricehistorydetail().getAvgsalaryassistant();
				float pasivelaboroperator = rutaspricehistory.getRutaspricehistorydetail().getPasivelaboroperator();
				float pasivelaborassistant = rutaspricehistory.getRutaspricehistorydetail().getAvgsalaryassistant();
				float expensestravel = (float) (((travels*cycletyme)/(localworkday*4.34)) * (1+backupmexico));
				float realoperators = (expensestravel/expensestravel)*expensestravel;//REVISAR FORMULA
				float assistants = realoperators;
				float totalworkforce = ((realoperators*avgsalaryoperator)+(avgsalaryassistant*assistants))*(1+fee);
				float totalfuel = ((travels*kmtravel)/yielditskm)*fuel;
				float totalmtto = travels*kmtravel*mttokm;
				float totalexpensestravel = 0*(1+fee)*travels;
				//float price = (totalworkforce+totalfuel+totalmtto+totalexpensestravel)/travels;
				float incrementtotalworkforce = totalworkforce*(1+5);
				float incrementtotalfuel = totalfuel*(1+8);
				float incrementtotalmtto = totalmtto*(1+9);
				float incrementtotalexpensestravel = totalexpensestravel*(1+4);
				float price = (incrementtotalworkforce+incrementtotalfuel+incrementtotalmtto+incrementtotalexpensestravel)/travels;
				rutaspricehistorydetail.setFuel(fuel);
				rutaspricehistorydetail.setMttokm(mttokm);
				rutaspricehistorydetail.setBackupmexico(backupmexico);
				rutaspricehistorydetail.setFee(fee);
				rutaspricehistorydetail.setLocalworkday(localworkday);
				rutaspricehistorydetail.setTravels(travels);
				rutaspricehistorydetail.setKmtravel(kmtravel);
				rutaspricehistorydetail.setCycletyme(cycletyme);
				rutaspricehistorydetail.setYielditskm(yielditskm);
				rutaspricehistorydetail.setAvgsalaryoperator(avgsalaryoperator);
				rutaspricehistorydetail.setAvgsalaryassistant(avgsalaryassistant);
				rutaspricehistorydetail.setExpensestravel(expensestravel);
				rutaspricehistorydetail.setRealoperators(realoperators);
				rutaspricehistorydetail.setAssistants(assistants);
				rutaspricehistorydetail.setTotalworkforce(totalworkforce);
				rutaspricehistorydetail.setTotalfuel(totalfuel);
				rutaspricehistorydetail.setTotalmtto(totalmtto);
				rutaspricehistorydetail.setTotalexpensestravel(totalexpensestravel);
				rutaspricehistorydetail.setPrice(price);
				rutaspricehistorydetail.setIncrementtotalworkforce(incrementtotalworkforce);
				rutaspricehistorydetail.setIncrementtotalfuel(incrementtotalfuel);
				rutaspricehistorydetail.setIncrementtotalmtto(incrementtotalmtto);
				rutaspricehistorydetail.setIncrementtotalexpensestravel(incrementtotalexpensestravel);
				rutaspricehistorydetail.setDatecreated( fechaActual );
				rutaspricehistorydetail.setDatemodified(fechaActual );	
				objRutaspricehistory.setPrice(price);
				objRutaspricehistory.setRutaspricehistorydetail(rutaspricehistorydetail);
				rutaspricehistorydetail.setRutaspricehistory(objRutaspricehistory);
				
				rutaspricehistoryService.addRutaspricehistory(objRutaspricehistory);
				return "redirect:/tarifario/getTarifasDetail/"+objRutaspricehistory.getId();	
			}
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", "La ruta ya existe." );				
			return "error";					
		}catch( Exception ex ){
			LoggerFacUtil.error(this.getClass().getName(), ex," tarifaPost() ");
			map.put("status", System.SISTEMA_ERROR );
			map.put("mensaje", System.SISTEMA_MENSAJE_ERROR );				
			return "error";			
		}
	}
	
}