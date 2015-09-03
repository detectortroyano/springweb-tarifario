package com.springweb.web.entity.tarifario;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the FOVARIABLES database table.
 * 
 */
@Entity
@Table(name="FOVARIABLES")
//@NamedQuery(name="Fovariable.findAll", query="SELECT f FROM Fovariable f")
public class Variable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FOVARIABLES_ID_GENERATOR", sequenceName="IDFOVARIABLES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOVARIABLES_ID_GENERATOR")
	private Integer id;

	private Date datecreated;

	private Date datemodified;

	private String description;
	
	private float value;

	public Variable() {
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