package com.springweb.web.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.web.entity.tarifario.Variable;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariableServiceImpl implements VariableService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
    public Variable getVariable(Integer id) {  
		try{			
			List<Variable> listVariable= sessionFactory.getCurrentSession().createQuery("from Variable u where u.id="+id).list();
			if (listVariable.size() > 0){
				return listVariable.get(0);
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
    }
	
	@Transactional
	public void addVariable(Variable variable){
		sessionFactory.getCurrentSession().save(variable);
	}
	
	@Transactional
	public void editVariable(Variable variable){
		sessionFactory.getCurrentSession().merge(variable);
	}
	
	@Transactional
	public void removeVariable(Integer id){
		Variable variable=(Variable) sessionFactory.getCurrentSession().get(Variable.class,id);
		if(variable!=null){
			sessionFactory.getCurrentSession().delete(variable);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Variable> listVariable(){
		List<Variable> listVariable = new ArrayList<Variable>();
		listVariable = sessionFactory.getCurrentSession().createQuery("from Variable").list();
		if (listVariable.size() > 0){
			return listVariable;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Variable getVariableByCondition(String condition){
		try{
			String query = " from Variable v " + condition;
			List<Variable> listVariable= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listVariable.size() > 0){
				return listVariable.get(0);
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
	public List<Variable> listVariableByCondition(String condition){
		try{
			String query = " from Variable v " + condition;
			List<Variable> listVariable= sessionFactory.getCurrentSession().createQuery( query ).list();
			if (listVariable.size() > 0){
				return listVariable;
			}else{
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}	
}
