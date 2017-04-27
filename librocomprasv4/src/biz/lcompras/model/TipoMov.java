package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="TIPOMOV",
uniqueConstraints={
        @UniqueConstraint(name="TIP_DESCRIPCION_DUPLICADA", columnNames={"DESCRIPCION"})        
})
public class TipoMov extends SuperClaseFeliz  {
	
	@Required
	@Column(length=200,nullable=false,name="DESCRIPCION")	
	private String descripcion ;	
	
	/*@Required
	@Pattern(regexp="^[12]$",message="1-LIBROCOMPRAS 2-LIBROVENTAS")	
	@Column(length=20,nullable=true,name="QUELIBRO")
	private String quelibro;*/
	
	private QueLibro quelibro;
	public enum QueLibro {LIBROCOMPRAS, LIBROVENTAS,LIBRORETENCIONES,COMPRASRETRASADAS };

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.toUpperCase().trim();
	}
	
	

	public QueLibro getQuelibro() {
		return quelibro;
	}

	public void setQuelibro(QueLibro quelibro) {
		this.quelibro = quelibro;
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
