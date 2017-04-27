package biz.lcompras.model;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;
// import com.compufiber.validadores.*;


//@View(members="ventasNro,fechaventas;sucursal,cliente;empleado,formadepago,estadoventa ; detalles; wexento,wgravado,wiva,wtotal;nrotjch")

@Entity
@Table(name="PROVEEDOR",
uniqueConstraints={
        @UniqueConstraint(name="PRV_NOMBRE_DUPLICADO", columnNames={"PRV_NOMBRE"})
        ,@UniqueConstraint(name="PRV_CODIGO_DUPLICADO", columnNames={"PRV_CODIGO"})        
})
@Tab(properties="codigo,nombre,ciudad",defaultOrder="${nombre} asc")
public class Proveedor extends SuperClaseFeliz {
	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="PRV_CODIGO")
	private String codigo ;

	@Required
	@Column(length=80,nullable=false,name="PRV_NOMBRE")	
	private String nombre ;

	@Column(length=100,nullable=true,name="PRV_CIUDAD")	
	private String ciudad ;	
	
	@Stereotype("MEMO")
	@Column(length=200,nullable=true,name="PRV_DIRECCION")	
	private String direccion ;	

	@Column(length=50,nullable=true,name="PRV_TELEFONO1")	
	private String telefono1 ;	

	@Column(length=50,nullable=true,name="PRV_TELEFONO2")	
	private String telefono2 ;	
	
	@Column(length=50,nullable=true,name="PRV_TELEFONO3")	
	private String telefono3 ;	
	
	@Stereotype("EMAIL")
	@Column(length=100,nullable=true,name="PRV_EMAIL")	
	private String email ;	
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.toUpperCase().trim();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase().trim();
	}
	
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion.toUpperCase().trim();
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1.toUpperCase().trim();
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2.toUpperCase().trim();
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3.toUpperCase().trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toUpperCase().trim();
	}

	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}	
}