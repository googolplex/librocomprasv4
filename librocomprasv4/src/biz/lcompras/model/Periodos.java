package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="PERIODOS")
public class Periodos extends SuperClaseFeliz {

@Required
@Range(min=0,max=9999)
@Column(name="PER_YYYY",length=4,nullable=false)
//@DefaultValueCalculator(CeroFelizLong.class)
@DefaultValueCalculator(CurrentYearCalculator.class)
private Long yyyy ;

@Required
@Range(min=1,max=12)
@Column(name="PER_MM",length=2,nullable=false)
@DefaultValueCalculator(CeroFelizLong.class)
private Long mes ;

@DescriptionsList(descriptionProperties="cteNombre",order="${cteNombre}")
@ManyToOne(fetch=FetchType.LAZY,optional=false)	
@JoinColumn(name="IDCONTRIB_ID", referencedColumnName="ID")
private Contribuyente contribuyente ;

@ReadOnly
@Column(length=10,nullable=true,name="CTE_CODIGO")	
private Long cteCodigo ;

@Hidden
@Column(length=10,nullable=true,name="PER_YYYYMM")
@DefaultValueCalculator(CeroFelizLong.class)
private Long yyyymm ;

public Long getYyyy() {
	return yyyy;
}
public void setYyyy(Long yyyy) {
	this.yyyy = yyyy;
}
public Long getMes() {
	return mes;
}
public void setMes(Long mes) {
	this.mes = mes;
}

public Contribuyente getContribuyente() {
	return contribuyente;
}
public void setContribuyente(Contribuyente contribuyente) {
	this.contribuyente = contribuyente;
}
public Long getCteCodigo() {
	return cteCodigo;
}
public void setCteCodigo(Long cteCodigo) {
	this.cteCodigo = cteCodigo;
}
public Long getYyyymm() {
	return yyyymm;
}
public void setYyyymm(Long yyyymm) {
	this.yyyymm = yyyymm;
}
private void camposCalculados () {
	this.setCteCodigo(this.contribuyente.getCteCodigo());
	this.setYyyymm(this.yyyy * 100 + this.mes);
}

@PrePersist
private void antesDeGrabar() {
	this.camposCalculados();
}
@PreUpdate
private void ultimoPaso() {
		Date mifechora = new java.util.Date() ;
		super.setModificadoPor(Users.getCurrent()) ;
		super.setFchUltMod(mifechora)  ;
		this.camposCalculados();
}
	
}
