package com.springweb.web.service;

import java.util.List;

import com.springweb.web.entity.tarifario.Rutaspricehistorydetail;

public interface RutaspricehistorydetailService {
	public Rutaspricehistorydetail getRutaspricehistorydetail(Integer id);
	public void addRutaspricehistorydetail(Rutaspricehistorydetail rutaspricehistorydetail);
	public void editRutaspricehistorydetail(Rutaspricehistorydetail rutaspricehistorydetail);
	public void removeRutaspricehistorydetail(Integer id);
	public List<Rutaspricehistorydetail> listRutaspricehistorydetail();
	public Rutaspricehistorydetail getRutaspricehistorydetailByCondition(String condition);
	public List<Rutaspricehistorydetail> listRutaspricehistorydetailByCondition(String condition);
	
}