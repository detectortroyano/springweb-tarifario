package com.springweb.web.service;

import java.util.List;

import com.springweb.web.entity.tarifario.Ruta;

public interface RutaService {
	public Ruta getRuta(Integer id);
	public void addRuta(Ruta ruta);
	public void editRuta(Ruta ruta);
	public void removeRuta(Integer id);
	public List<Ruta> listRuta();
	public Ruta getRutaByCondition(String condition);
	public List<Ruta> listRutaByCondition(String condition);
	
}