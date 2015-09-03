package com.springweb.web.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.springweb.web.entity.User;

public final class WebUtil{
	
	/**
	 * Method getFechaHoraString
	 * 
	 * @param date: la fecha como objeto java.util.Date
	 * @return dateString: la fecha transformada a String con formato
	 *         "yyyy-MM-dd HH:mm"
	 */
	public static String getFechaHoraFromDate(Date date) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}catch( Exception ex ){
			return null;
		}		
	}
	
	/**
	 * Method getFechaHoraFromString
	 * 
	 * @param fechaHora: la fecha como String con formato "yyyy-MM-dd HH:mm:ss"
	 * @return date: la fecha transformada a un objeto java.util.Date
	 */
	public static Date getFechaHoraFromString(String fechaHora) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(fechaHora);
		}catch( Exception ex ){
			return null;
		}
	}	

	public static Date getFechaHoraActual(){
		Date now = Calendar.getInstance().getTime();		
		String fechaString = WebUtil.getFechaHoraFromDate(now);
		Date fecha;
		try {
			fecha = WebUtil.getFechaHoraFromString(fechaString);
		} catch (Exception e) {
			fecha = now;
		}
		return fecha;
	}	
	
	public static String getUserNameFromPrincipal(){
		String userName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( principal instanceof UserDetails ){
			userName = ((UserDetails)principal).getUsername();
		}else if( principal instanceof User ){
			userName = principal.toString();
		}
		return userName;
	} 
	
	public static String getUserNameFromAuthentication(){
		String userName = "";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		userName = auth.getName();
		return userName;
	}	
	
	public static boolean isRolePresent(Collection<GrantedAuthority> authorities, String role) {
		boolean isRolePresent = false;
		for (GrantedAuthority grantedAuthority : authorities) {
		isRolePresent = grantedAuthority.getAuthority().equals(role);
		if (isRolePresent) break;
		}
		return isRolePresent;
	}
	
	public static String getMainRole() {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role = "";
		for (GrantedAuthority grantedAuthority : authorities) {
			role = grantedAuthority.getAuthority();
			break;
		}
		return role;
	}	
	
	public static List<String> getRoles(String role) {
		List<String> roles= new ArrayList<String>();
		if ( role.equals( System.ROLE_ADMIN_DB ) ) {
			roles.add("ROLE_ADMIN");
		}else if ( role.equals( System.ROLE_USER_DB ) ) {
			roles.add("ROLE_USER");
		}else if ( role.equals( System.ROLE_ADMINISTRADOR_TARIFAS_DB ) ) {
			roles.add("ROLE_ADMINISTRADOR_TARIFAS");
		}
		return roles;
	}	
	
}