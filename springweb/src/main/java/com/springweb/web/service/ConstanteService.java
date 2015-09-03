package com.springweb.web.service;

import java.util.List;

import com.springweb.web.entity.tarifario.Constante;

public interface ConstanteService {
	public Constante getConstante(Integer id);
	public void addConstante(Constante constante);
	public void editConstante(Constante constante);
	public void removeConstante(Integer id);
	public List<Constante> listConstante();
	public Constante getConstanteByCondition(String condition);
	public List<Constante> listConstanteByCondition(String condition);
	
}
