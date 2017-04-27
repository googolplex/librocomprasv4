package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

@MappedSuperclass
public class SuperClaseFeliz {
	@Hidden
	@Id
	@SequenceGenerator(name="HIBERNATE_SEQUENCE",sequenceName="HIBERNATE_SEQUENCE",allocationSize=1)	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="HIBERNATE_SEQUENCE")
	
	@Digits(integer=19, fraction = 0)
	@Column(name="ID")
	private Long id ;

	@Version
	@Column(name="VERSION")
	private Long miVersion ;	
	
	@Hidden
	@Column(name="LASTUPDATED")
	private Date	fchUltMod = new java.util.Date() ; // carga solo cuando se crea

	@Hidden	
	@Column(name="DATECREATED")
	@DefaultValueCalculator(CurrentDateCalculator.class)	// no funciona cuando es un campo oculto
	private Date	fchAlta = new java.util.Date() ; // carga solo cuando se crea

	@Hidden
	@DefaultValueCalculator(CurrentUserCalculator.class)
	@Column(length=50,name="USUARIO")	
	private String	creadoPor = Users.getCurrent() ;

	@Hidden
	@DefaultValueCalculator(CurrentUserCalculator.class)	
	@Column(length=50,name="MODIFICADOPOR")	
	private String	modificadoPor = Users.getCurrent() ; // porque es un campo oculto


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMiVersion() {
		return miVersion;
	}

	public void setMiVersion(Long miVersion) {
		this.miVersion = miVersion;
	}

	public Date getFchUltMod() {
		return fchUltMod;
	}

	public void setFchUltMod(Date fchUltMod) {
		this.fchUltMod = fchUltMod;
	}

	public Date getFchAlta() {
		return fchAlta;
	}

	public void setFchAlta(Date fchAlta) {
		this.fchAlta = fchAlta;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	
}	