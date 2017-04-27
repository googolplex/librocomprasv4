package biz.lcompras.model;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="TIPO_IVA",
uniqueConstraints={
        @UniqueConstraint(name="TIP_CODIGO_DUPLICADA", columnNames={"TIVA_COD"})
        ,@UniqueConstraint(name="TIP_NOMBRE_DUPLICADA", columnNames={"TIVA_NOMBRE"})
})
public class TipoIva extends SuperClaseFeliz  {
	
	@Required
	@Column(length=5,nullable=false,name="TIVA_COD")	
	private Long tivacod ;	
	
	@Required
	@Column(length=40,nullable=false,name="TIVA_NOMBRE")	
	private String tivanombre ;
	

	public Long getTivacod() {
		return tivacod;
	}

	public void setTivacod(Long tivacod) {
		this.tivacod = tivacod;
	}

	public String getTivanombre() {
		return tivanombre;
	}

	public void setTivanombre(String tivanombre) {
		this.tivanombre = tivanombre.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
