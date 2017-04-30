package biz.lcompras.model;

import javax.persistence.*;

// es una vista en la base de datos
@Entity
@Table(name="VISTA_LIBROCOMPRAS")
public class VistaLibroCompras extends SuperClaseFeliz {

@Column(length=20,name="Q22")	
private Long  	q22 ;

@Column(length=10,name="CONTRIBUYENTE")
private String contribuyente ;

//@Stereotype("DATE")
@Column(name="LC_FECHA")
private String fecha ;

@Column(length=80,name="proveedor")
private String proveedor;

@Column(length=20,name="EXENTO",scale=0)
private Double exento ;

@Column(length=20,name="GRAV10",scale=0)
private Double grav10 ;

@Column(length=20,name="GRAV5",scale=0)
private Double grav5;

@Column(length=20,name="IVA10",scale=0)
private Double iva10 ;

@Column(length=20,name="IVA5",scale=0)
private Double iva5;

@Column(length=20,name="TOTAL",scale=0)
private Double total ;

@Column(length=6,name="LC_PERIODO")
private String lc_periodo ;

@Column(length=20,name="LC_NUMEROFACTURA")
private String lc_numerofactura ;

@Column(length=4,name="TIVA")
private Long tiva ;

@Column(length=80,name="TIPOMOV")
private String tipomov ;

public Long getQ22() {
	return q22;
}

public String getContribuyente() {
	return contribuyente;
}

public String getFecha() {
	return fecha;
}

public String getProveedor() {
	return proveedor;
}

public Double getExento() {
	return exento;
}

public Double getGrav10() {
	return grav10;
}

public Double getGrav5() {
	return grav5;
}

public Double getIva10() {
	return iva10;
}

public Double getIva5() {
	return iva5;
}

public Double getTotal() {
	return total;
}

public String getLc_periodo() {
	return lc_periodo;
}

public String getLc_numerofactura() {
	return lc_numerofactura;
}

public Long getTiva() {
	return tiva;
}

public String getTipomov() {
	return tipomov;
}





}

