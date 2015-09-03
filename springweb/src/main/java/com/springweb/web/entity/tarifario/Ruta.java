package com.springweb.web.entity.tarifario;

import java.io.Serializable;

import javax.persistence.*;

import com.springweb.web.entity.User;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FORUTAS database table.
 * 
 */
@Entity
@Table(name="FORUTAS")
//@NamedQuery(name="Foruta.findAll", query="SELECT f FROM Foruta f")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORUTAS_ID_GENERATOR", sequenceName="IDFORUTAS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORUTAS_ID_GENERATOR")
	private Integer id;

	private Date datecreated;

	private Date datemodified;

	private String description;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDUSER")
	private User user;

	//bi-directional many-to-one association to Forutaspricehistory
	@OneToMany(fetch=FetchType.EAGER, mappedBy="ruta")
	private List<Rutaspricehistory> rutaspricehistories;

	public Ruta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public Date getDatemodified() {
		return this.datemodified;
	}

	public void setDatemodified(Date datemodified) {
		this.datemodified = datemodified;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Rutaspricehistory> getRutaspricehistories() {
		return this.rutaspricehistories;
	}

	public void setRutaspricehistories(List<Rutaspricehistory> rutaspricehistories) {
		this.rutaspricehistories = rutaspricehistories;
	}

	public Rutaspricehistory addRutaspricehistory(Rutaspricehistory rutaspricehistory) {
		getRutaspricehistories().add(rutaspricehistory);
		rutaspricehistory.setRuta(this);

		return rutaspricehistory;
	}

	public Rutaspricehistory removeRutaspricehistory(Rutaspricehistory rutaspricehistory) {
		getRutaspricehistories().remove(rutaspricehistory);
		rutaspricehistory.setRuta(null);

		return rutaspricehistory;
	}

}