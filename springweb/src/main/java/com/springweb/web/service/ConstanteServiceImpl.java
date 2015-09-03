package com.springweb.web.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.web.entity.tarifario.Constante;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstanteServiceImpl implements ConstanteService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
    public Constante getConstante(Integer id) {  
		try{			
			List<Constante> listConstante= sessionFactory.getCurrentSession().createQuery("from Constante u where u.id="+id).list();
			if (listConstante.size() > 0){
				return listConstante.get(0);
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
    }
	
	@Transactional
	public void addConstante(Constante constante){
		sessionFactory.getCurrentSession().save(constante);
	}
	
	@Transactional
	public void editConstante(Constante constante){
		sessionFactory.getCurrentSession().merge(constante);
	}
	
	@Transactional
	public void removeConstante(Integer id){
		Constante constante=(Constante) sessionFactory.getCurrentSession().get(Constante.class,id);
		if(constante!=null){
			sessionFactory.getCurrentSession().delete(constante);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Constante> listConstante(){
		List<Constante> listConstante = new ArrayList<Constante>();
		listConstante = sessionFactory.getCurrentSession().createQuery("from Constante").list();
		if (listConstante.size() > 0){
			return listConstante;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Constante getConstanteByCondition(String condition){
		try{
			String query = " from Constante c " + condition;
			List<Constante> listConstante= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listConstante.size() > 0){
				return listConstante.get(0);
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
	public List<Constante> listConstanteByCondition(String condition){
		try{
			String query = " from Constante c " + condition;
			List<Constante> listConstante= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listConstante.size() > 0){
				return listConstante;
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}	
}
