package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="CONTRIBUYENTE",
uniqueConstraints={
        @UniqueConstraint(name="CON_CODIGO_DUPLICADO", columnNames={"CTE_CODIGO"}),
        @UniqueConstraint(name="CON_NOMBRE_DUPLICADO", columnNames={"CTE_NOMBRE"})
})
public class Contribuyente extends SuperClaseFeliz  {
	
	@Required
	@Column(length=10,nullable=false,name="CTE_CODIGO")	
	private Long cteCodigo ;	
	
	@Required
	@Column(length=40,nullable=false,name="CTE_NOMBRE")	
	private String cteNombre ;

	@Required
	@Pattern(regexp="^(SI|NO)$",message="Solo SI / NO ")	
	@Column(length=20,nullable=false,name="ACTIVO")	
	private String activo ;
	


	public Long getCteCodigo() {
		return cteCodigo;
	}

	public void setCteCodigo(Long cteCodigo) {
		this.cteCodigo = cteCodigo;
	}

	public String getCteNombre() {
		return cteNombre;
	}

	public void setCteNombre(String cteNombre) {
		this.cteNombre = cteNombre.toUpperCase().trim();
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
