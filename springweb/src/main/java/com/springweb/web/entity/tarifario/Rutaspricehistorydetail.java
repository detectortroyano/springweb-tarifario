package com.springweb.web.entity.tarifario;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the FORUTASPRICEHISTORYDETAIL database table.
 * 
 */
@Entity
@Table(name="FORUTASPRICEHISTORYDETAIL")
//@NamedQuery(name="Forutaspricehistorydetail.findAll", query="SELECT f FROM Forutaspricehistorydetail f")
public class Rutaspricehistorydetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORUTASPRICEHISTORYDETAIL_ID_GENERATOR", sequenceName="IDFORUTASPRICEHISTORYDET_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORUTASPRICEHISTORYDETAIL_ID_GENERATOR")
	private Integer id;

	private float assistants;

	private float assistanttravel;

	private float avgsalaryassistant;

	private float avgsalaryoperator;

	private float backupmexico;

	private float cycletimeassistant;

	private float cycletyme;

	private Date datecreated;

	private Date datemodified;

	private float expensestravel;

	private float fee;

	private float foreingworkday;

	private float fuel;

	private float incrementtotalexpensestravel;

	private float incrementtotalfuel;

	private float incrementtotalmtto;

	private float incrementtotalworkforce;

	private float kmtravel;

	private float localworkday;

	private float mttokm;

	private float pasivelaborassistant;

	private float pasivelaboroperator;

	private float price;

	private float realoperators;

	private float totalexpensestravel;

	private float totalfuel;

	private float totalmtto;

	private float totalworkforce;

	private float travels;

	private float yielditskm;

	//bi-directional one-to-one association to Forutaspricehistory
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Rutaspricehistory rutaspricehistory;

	public Rutaspricehistorydetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getAssistants() {
		return this.assistants;
	}

	public void setAssistants(float assistants) {
		this.assistants = assistants;
	}

	public float getAssistanttravel() {
		return this.assistanttravel;
	}

	public void setAssistanttravel(float assistanttravel) {
		this.assistanttravel = assistanttravel;
	}

	public float getAvgsalaryassistant() {
		return this.avgsalaryassistant;
	}

	public void setAvgsalaryassistant(float avgsalaryassistant) {
		this.avgsalaryassistant = avgsalaryassistant;
	}

	public float getAvgsalaryoperator() {
		return this.avgsalaryoperator;
	}

	public void setAvgsalaryoperator(float avgsalaryoperator) {
		this.avgsalaryoperator = avgsalaryoperator;
	}

	public float getBackupmexico() {
		return this.backupmexico;
	}

	public void setBackupmexico(float backupmexico) {
		this.backupmexico = backupmexico;
	}

	public float getCycletimeassistant() {
		return this.cycletimeassistant;
	}

	public void setCycletimeassistant(float cycletimeassistant) {
		this.cycletimeassistant = cycletimeassistant;
	}

	public float getCycletyme() {
		return this.cycletyme;
	}

	public void setCycletyme(float cycletyme) {
		this.cycletyme = cycletyme;
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

	public float getExpensestravel() {
		return this.expensestravel;
	}

	public void setExpensestravel(float expensestravel) {
		this.expensestravel = expensestravel;
	}

	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public float getForeingworkday() {
		return this.foreingworkday;
	}

	public void setForeingworkday(float foreingworkday) {
		this.foreingworkday = foreingworkday;
	}

	public float getFuel() {
		return this.fuel;
	}

	public void setFuel(float fuel) {
		this.fuel = fuel;
	}

	public float getIncrementtotalexpensestravel() {
		return this.incrementtotalexpensestravel;
	}

	public void setIncrementtotalexpensestravel(float incrementtotalexpensestravel) {
		this.incrementtotalexpensestravel = incrementtotalexpensestravel;
	}

	public float getIncrementtotalfuel() {
		return this.incrementtotalfuel;
	}

	public void setIncrementtotalfuel(float incrementtotalfuel) {
		this.incrementtotalfuel = incrementtotalfuel;
	}

	public float getIncrementtotalmtto() {
		return this.incrementtotalmtto;
	}

	public void setIncrementtotalmtto(float incrementtotalmtto) {
		this.incrementtotalmtto = incrementtotalmtto;
	}

	public float getIncrementtotalworkforce() {
		return this.incrementtotalworkforce;
	}

	public void setIncrementtotalworkforce(float incrementtotalworkforce) {
		this.incrementtotalworkforce = incrementtotalworkforce;
	}

	public float getKmtravel() {
		return this.kmtravel;
	}

	public void setKmtravel(float kmtravel) {
		this.kmtravel = kmtravel;
	}

	public float getLocalworkday() {
		return this.localworkday;
	}

	public void setLocalworkday(float localworkday) {
		this.localworkday = localworkday;
	}

	public float getMttokm() {
		return this.mttokm;
	}

	public void setMttokm(float mttokm) {
		this.mttokm = mttokm;
	}

	public float getPasivelaborassistant() {
		return this.pasivelaborassistant;
	}

	public void setPasivelaborassistant(float pasivelaborassistant) {
		this.pasivelaborassistant = pasivelaborassistant;
	}

	public float getPasivelaboroperator() {
		return this.pasivelaboroperator;
	}

	public void setPasivelaboroperator(float pasivelaboroperator) {
		this.pasivelaboroperator = pasivelaboroperator;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRealoperators() {
		return this.realoperators;
	}

	public void setRealoperators(float realoperators) {
		this.realoperators = realoperators;
	}

	public float getTotalexpensestravel() {
		return this.totalexpensestravel;
	}

	public void setTotalexpensestravel(float totalexpensestravel) {
		this.totalexpensestravel = totalexpensestravel;
	}

	public float getTotalfuel() {
		return this.totalfuel;
	}

	public void setTotalfuel(float totalfuel) {
		this.totalfuel = totalfuel;
	}

	public float getTotalmtto() {
		return this.totalmtto;
	}

	public void setTotalmtto(float totalmtto) {
		this.totalmtto = totalmtto;
	}

	public float getTotalworkforce() {
		return this.totalworkforce;
	}

	public void setTotalworkforce(float totalworkforce) {
		this.totalworkforce = totalworkforce;
	}

	public float getTravels() {
		return this.travels;
	}

	public void setTravels(float travels) {
		this.travels = travels;
	}

	public float getYielditskm() {
		return this.yielditskm;
	}

	public void setYielditskm(float yielditskm) {
		this.yielditskm = yielditskm;
	}

	public Rutaspricehistory getRutaspricehistory() {
		return this.rutaspricehistory;
	}

	public void setRutaspricehistory(Rutaspricehistory rutaspricehistory) {
		this.rutaspricehistory = rutaspricehistory;
	}

}