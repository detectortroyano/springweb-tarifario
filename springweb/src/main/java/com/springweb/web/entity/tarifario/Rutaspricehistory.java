package com.springweb.web.entity.tarifario;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the FORUTASPRICEHISTORY database table.
 * 
 */
@Entity
@Table(name="FORUTASPRICEHISTORY")
//@NamedQuery(name="Forutaspricehistory.findAll", query="SELECT f FROM Forutaspricehistory f")
public class Rutaspricehistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORUTASPRICEHISTORY_ID_GENERATOR", sequenceName="IDFORUTASPRICEHISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORUTASPRICEHISTORY_ID_GENERATOR")
	private Integer id;

	private Date datecreated;

	private Date datemodified;
	
	private Integer idestatus;

	private float price;

	//bi-directional many-to-one association to Foruta
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDROUTE")
	private Ruta ruta;

	//bi-directional one-to-one association to Forutaspricehistorydetail
	@OneToOne(fetch=FetchType.LAZY, mappedBy="rutaspricehistory", cascade = CascadeType.ALL)
	@JoinColumn(name="ID", referencedColumnName="ID")
	private Rutaspricehistorydetail rutaspricehistorydetail;
	
	private transient float costoCombustible;
	
	private transient float mttokm;
	
	private transient float backupmexico;
	
	private transient float fee;
	
	private transient float jornadaLaboralForaneo;
	
	private transient float jornadaLaboralLocal;
	
	private transient float viajes;
	
	private transient float ayudantesXViaje;

	public Rutaspricehistory() {
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
	
	public Integer getIdestatus() {
		return this.idestatus;
	}

	public void setIdestatus(Integer idestatus) {
		this.idestatus = idestatus;
	}	

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Rutaspricehistorydetail getRutaspricehistorydetail() {
		return this.rutaspricehistorydetail;
	}

	public void setRutaspricehistorydetail(Rutaspricehistorydetail rutaspricehistorydetail) {
		this.rutaspricehistorydetail = rutaspricehistorydetail;
	}

	public float getCostoCombustible() {
		return costoCombustible;
	}

	public void setCostoCombustible(float costoCombustible) {
		this.costoCombustible = costoCombustible;
	}

	public float getMttokm() {
		return mttokm;
	}

	public void setMttokm(float mttokm) {
		this.mttokm = mttokm;
	}

	public float getBackupmexico() {
		return backupmexico;
	}

	public void setBackupmexico(float backupmexico) {
		this.backupmexico = backupmexico;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public float getJornadaLaboralForaneo() {
		return jornadaLaboralForaneo;
	}

	public void setJornadaLaboralForaneo(float jornadaLaboralForaneo) {
		this.jornadaLaboralForaneo = jornadaLaboralForaneo;
	}

	public float getJornadaLaboralLocal() {
		return jornadaLaboralLocal;
	}

	public void setJornadaLaboralLocal(float jornadaLaboralLocal) {
		this.jornadaLaboralLocal = jornadaLaboralLocal;
	}

	public float getViajes() {
		return viajes;
	}

	public void setViajes(float viajes) {
		this.viajes = viajes;
	}

	public float getAyudantesXViaje() {
		return ayudantesXViaje;
	}

	public void setAyudantesXViaje(float ayudantesXViaje) {
		this.ayudantesXViaje = ayudantesXViaje;
	}

}