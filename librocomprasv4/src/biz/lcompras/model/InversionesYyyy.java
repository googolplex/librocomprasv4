package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

@Entity
@Table(name="INVERSIONESYYYY"
,uniqueConstraints={
   @UniqueConstraint(name="INV_INVERSION_DUPLICADA", columnNames={"INV_YYYY","IDCONTRIB_ID","IDPROV_ID"})
  }
)

@Tab(properties= "yyyy, contribuyente.cteNombre, proveedor.nombre", defaultOrder="${yyyy} desc")
@View(members="yyyy,contribuyente;proveedor")
public class InversionesYyyy extends SuperClaseFeliz {

	@Required
	@Range(min=0,max=9999)
	@Column(name="INV_YYYY",length=4,nullable=false)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	private Long yyyy ;
	
	@DescriptionsList(descriptionProperties="cteNombre",order="${cteNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCONTRIB_ID", referencedColumnName="ID")
	private Contribuyente contribuyente ;
	
	
	@DescriptionsList(descriptionProperties="nombre",order="${nombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDPROV_ID", referencedColumnName="ID")
	private Proveedor proveedor ;
	
	public Long getYyyy() {
		return yyyy;
	}

	public void setYyyy(Long yyyy) {
		this.yyyy = yyyy;
	}

	public Contribuyente getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}			
	
}
