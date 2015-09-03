package com.springweb.web.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.web.entity.tarifario.Rutaspricehistorydetail;

import java.util.ArrayList;
import java.util.List;

@Service
public class RutaspricehistorydetailServiceImpl implements RutaspricehistorydetailService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
    public Rutaspricehistorydetail getRutaspricehistorydetail(Integer id) {  
		try{			
			List<Rutaspricehistorydetail> listRutaspricehistorydetail= sessionFactory.getCurrentSession().createQuery("from Rutaspricehistorydetail u where u.id="+id).list();
			if (listRutaspricehistorydetail.size() > 0){
				return listRutaspricehistorydetail.get(0);
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
    }
	
	@Transactional
	public void addRutaspricehistorydetail(Rutaspricehistorydetail rutaspricehistorydetail){
		sessionFactory.getCurrentSession().save(rutaspricehistorydetail);
	}
	
	@Transactional
	public void editRutaspricehistorydetail(Rutaspricehistorydetail rutaspricehistorydetail){
		sessionFactory.getCurrentSession().merge(rutaspricehistorydetail);
	}
	
	@Transactional
	public void removeRutaspricehistorydetail(Integer id){
		Rutaspricehistorydetail rutaspricehistorydetail=(Rutaspricehistorydetail) sessionFactory.getCurrentSession().get(Rutaspricehistorydetail.class,id);
		if(rutaspricehistorydetail!=null){
			sessionFactory.getCurrentSession().delete(rutaspricehistorydetail);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Rutaspricehistorydetail> listRutaspricehistorydetail(){
		List<Rutaspricehistorydetail> listRutaspricehistorydetail = new ArrayList<Rutaspricehistorydetail>();
		listRutaspricehistorydetail = sessionFactory.getCurrentSession().createQuery("from Rutaspricehistorydetail").list();
		if (listRutaspricehistorydetail.size() > 0){
			return listRutaspricehistorydetail;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Rutaspricehistorydetail getRutaspricehistorydetailByCondition(String condition){
		try{
			String query = " from Rutaspricehistorydetail u " + condition;
			List<Rutaspricehistorydetail> listRutaspricehistorydetail= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listRutaspricehistorydetail.size() > 0){
				return listRutaspricehistorydetail.get(0);
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
	public List<Rutaspricehistorydetail> listRutaspricehistorydetailByCondition(String condition){
		try{
			String query = " from Rutaspricehistorydetail u " + condition;
			List<Rutaspricehistorydetail> listRutaspricehistorydetail= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listRutaspricehistorydetail.size() > 0){
				return listRutaspricehistorydetail;
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}	
}
