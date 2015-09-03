package com.springweb.web.entity.tarifario;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the FOCONSTANTES database table.
 * 
 */
@Entity
@Table(name="FOCONSTANTES")
//@NamedQuery(name="Foconstante.findAll", query="SELECT f FROM Foconstante f")
public class Constante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FOCONSTANTES_ID_GENERATOR", sequenceName="IDFOCONSTANTES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOCONSTANTES_ID_GENERATOR")
	private Integer id;

	private Date datecreated;

	private Date datemodified;

	private String description;
	
	private float value;

	public Constante() {
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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}