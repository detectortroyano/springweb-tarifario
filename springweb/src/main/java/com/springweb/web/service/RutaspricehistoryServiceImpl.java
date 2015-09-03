package com.springweb.web.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.web.entity.tarifario.Rutaspricehistory;

import java.util.ArrayList;
import java.util.List;

@Service
public class RutaspricehistoryServiceImpl implements RutaspricehistoryService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
    public Rutaspricehistory getRutaspricehistory(Integer id) {  
		try{			
			List<Rutaspricehistory> listRutaspricehistory= sessionFactory.getCurrentSession().createQuery("from Rutaspricehistory u where u.id="+id).list();
			if (listRutaspricehistory.size() > 0){
				return listRutaspricehistory.get(0);
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
    }
	
	@Transactional
	public void addRutaspricehistory(Rutaspricehistory rutaspricehistory){
		sessionFactory.getCurrentSession().save(rutaspricehistory);
	}
	
	@Transactional
	public void editRutaspricehistory(Rutaspricehistory rutaspricehistory){
		sessionFactory.getCurrentSession().merge(rutaspricehistory);
	}
	
	@Transactional
	public void removeRutaspricehistory(Integer id){
		Rutaspricehistory rutaspricehistory=(Rutaspricehistory) sessionFactory.getCurrentSession().get(Rutaspricehistory.class,id);
		if(rutaspricehistory!=null){
			sessionFactory.getCurrentSession().delete(rutaspricehistory);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Rutaspricehistory> listRutaspricehistory(){
		List<Rutaspricehistory> listRutaspricehistory = new ArrayList<Rutaspricehistory>();
		listRutaspricehistory = sessionFactory.getCurrentSession().createQuery("from Rutaspricehistory").list();
		if (listRutaspricehistory.size() > 0){
			return listRutaspricehistory;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Rutaspricehistory getRutaspricehistoryByCondition(String condition){
		try{
			String query = " from Rutaspricehistory u " + condition;
			List<Rutaspricehistory> listRutaspricehistory= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listRutaspricehistory.size() > 0){
				return listRutaspricehistory.get(0);
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Rutaspricehistory> listRutaspricehistoryByCondition(String condition){
		try{
			String query = " from Rutaspricehistory rph " + condition;
			List<Rutaspricehistory> listRutaspricehistory= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listRutaspricehistory.size() > 0){
				return listRutaspricehistory;
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}	
}
