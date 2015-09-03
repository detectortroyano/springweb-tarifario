package com.springweb.web.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.web.entity.tarifario.Ruta;

import java.util.ArrayList;
import java.util.List;

@Service
public class RutaServiceImpl implements RutaService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
    public Ruta getRuta(Integer id) {  
		try{			
			List<Ruta> listRuta= sessionFactory.getCurrentSession().createQuery("from Ruta u where u.id="+id).list();
			if (listRuta.size() > 0){
				return listRuta.get(0);
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
    }
	
	@Transactional
	public void addRuta(Ruta ruta){
		sessionFactory.getCurrentSession().save(ruta);
	}
	
	@Transactional
	public void editRuta(Ruta ruta){
		sessionFactory.getCurrentSession().merge(ruta);
	}
	
	@Transactional
	public void removeRuta(Integer id){
		Ruta ruta=(Ruta) sessionFactory.getCurrentSession().get(Ruta.class,id);
		if(ruta!=null){
			sessionFactory.getCurrentSession().delete(ruta);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Ruta> listRuta(){
		List<Ruta> listRuta = new ArrayList<Ruta>();
		listRuta = sessionFactory.getCurrentSession().createQuery("from Ruta").list();
		if (listRuta.size() > 0){
			return listRuta;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Ruta getRutaByCondition(String condition){
		try{
			String query = " from Ruta r " + condition;
			List<Ruta> listRuta= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listRuta.size() > 0){
				return listRuta.get(0);
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
	public List<Ruta> listRutaByCondition(String condition){
		try{
			String query = " from Ruta r " + condition;
			List<Ruta> listRuta= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listRuta.size() > 0){
				return listRuta;
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}	
}
