package com.springweb.web.service;

import java.util.List;

import com.springweb.web.entity.tarifario.Rutaspricehistory;

public interface RutaspricehistoryService {
	public Rutaspricehistory getRutaspricehistory(Integer id);
	public void addRutaspricehistory(Rutaspricehistory rutaspricehistory);
	public void editRutaspricehistory(Rutaspricehistory rutaspricehistory);
	public void removeRutaspricehistory(Integer id);
	public List<Rutaspricehistory> listRutaspricehistory();
	public Rutaspricehistory getRutaspricehistoryByCondition(String condition);
	public List<Rutaspricehistory> listRutaspricehistoryByCondition(String condition);
	
}