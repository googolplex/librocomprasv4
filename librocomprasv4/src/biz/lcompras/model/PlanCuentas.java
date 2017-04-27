package biz.lcompras.model;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="PLANCUENTAS",
uniqueConstraints={
        @UniqueConstraint(name="PLA_CUENTA_DUPLICADA", columnNames={"CODIGOCUENTA"})        
})
public class PlanCuentas extends SuperClaseFeliz  {
	
	@Required
	@Column(length=20,nullable=false,name="CODIGOCUENTA")	
	private Double codigocuenta;
	
	@Required
	@Column(length=200,nullable=false,name="CUENTAEDITADA")
	private String cuentaeditada;
	
	@Required
	@Column(length=200,nullable=false,name="CUENTA")
	private String cuenta;
	
	@Required
	@Column(length=2,nullable=false,name="IMPUTABLE")
	private String imputable;
	
	@Required
	@Column(length=200,nullable=false,name="CODIGOALFA")
	private String codigoalfa;

	public Double getCodigocuenta() {
		return codigocuenta;
	}

	public void setCodigocuenta(Double codigocuenta) {
		this.codigocuenta = codigocuenta;
	}

	public String getCuentaeditada() {
		return cuentaeditada;
	}

	public void setCuentaeditada(String cuentaeditada) {
		this.cuentaeditada = cuentaeditada.toUpperCase().trim();
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta.toUpperCase().trim();
	}
	
	public String getImputable() {
		return imputable;
	}

	public void setImputable(String imputable) {
		this.imputable = imputable.toUpperCase().trim();
	}

	public String getCodigoalfa() {
		return codigoalfa;
	}

	public void setCodigoalfa(String codigoalfa) {
		this.codigoalfa = codigoalfa.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
