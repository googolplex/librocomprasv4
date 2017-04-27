package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="CLIENTE"
 , uniqueConstraints={
        @UniqueConstraint(name="CLI_CODIGO_DUPLICADO", columnNames={"CLI_CODIGO"})
        , @UniqueConstraint(name="CLI_NOMBRE_DUPLICADO", columnNames={"CLI_NOMBRE"})        
 }
)
public class Cliente extends SuperClaseFeliz {

	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="CLI_CODIGO")		
	private String cliCodigo;
	@Required
	@Column(length=80,nullable=false,name="CLI_NOMBRE")		
	private String cliNombre;

	
	public String getCliCodigo() {
		return cliCodigo;
	}

	public void setCliCodigo(String cliCodigo) {
		this.cliCodigo = cliCodigo.toUpperCase().trim();
	}

	public String getCliNombre() {
		return cliNombre;
	}



	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
