package com.springweb.web.service;

import java.util.List;

import com.springweb.web.entity.tarifario.Variable;

public interface VariableService {
	public Variable getVariable(Integer id);
	public void addVariable(Variable variable);
	public void editVariable(Variable variable);
	public void removeVariable(Integer id);
	public List<Variable> listVariable();
	public Variable getVariableByCondition(String condition);
	public List<Variable> listVariableByCondition(String condition);
	
}