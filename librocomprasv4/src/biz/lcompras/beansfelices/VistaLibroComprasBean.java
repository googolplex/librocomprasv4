package biz.lcompras.beansfelices;

import java.sql.*;

public class VistaLibroComprasBean {
	private Double id ;
	private Double version ;
	private Long  	q22 ;
	private Long cta_codigo ;
	private String lc_fecha ;
	private String contribuyente ;
	private String fecha ;
	private String proveedor;
	private Double exento ;
	private Double grav10 ;
	private Double grav5;
	private Double iva10 ;
	private Double iva5;
	private Double total ;
	private String lc_periodo ;
	private String lc_numerofactura ;
	private Long tiva ;
	private String tipomov ;
	private Long cte_codigo ;
	private Date datecreated ;
	private Date lastupdated ;
	private String usuario ;
	private String modificadopor ;
	private String yyyymm ;
	

	
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public Date getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getModificadopor() {
		return modificadopor;
	}
	public void setModificadopor(String modificadopor) {
		this.modificadopor = modificadopor;
	}
	public String getYyyymm() {
		return yyyymm;
	}
	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}
	public Long getCte_codigo() {
		return cte_codigo;
	}
	public void setCte_codigo(Long cte_codigo) {
		this.cte_codigo = cte_codigo;
	}

	public String getLc_fecha() {
		return lc_fecha;
	}
	public void setLc_fecha(String lc_fecha) {
		this.lc_fecha = lc_fecha;
	}
	public Long getCta_codigo() {
		return cta_codigo;
	}
	public void setCta_codigo(Long cta_codigo) {
		this.cta_codigo = cta_codigo;
	}
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double version) {
		this.version = version;
	}
	public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public Long getQ22() {
		return q22;
	}
	public void setQ22(Long q22) {
		this.q22 = q22;
	}
	public String getContribuyente() {
		return contribuyente;
	}
	public void setContribuyente(String contribuyente) {
		this.contribuyente = contribuyente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public Double getExento() {
		return exento;
	}
	public void setExento(Double exento) {
		this.exento = exento;
	}
	public Double getGrav10() {
		return grav10;
	}
	public void setGrav10(Double grav10) {
		this.grav10 = grav10;
	}
	public Double getGrav5() {
		return grav5;
	}
	public void setGrav5(Double grav5) {
		this.grav5 = grav5;
	}
	public Double getIva10() {
		return iva10;
	}
	public void setIva10(Double iva10) {
		this.iva10 = iva10;
	}
	public Double getIva5() {
		return iva5;
	}
	public void setIva5(Double iva5) {
		this.iva5 = iva5;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getLc_periodo() {
		return lc_periodo;
	}
	public void setLc_periodo(String lc_periodo) {
		this.lc_periodo = lc_periodo;
	}
	public String getLc_numerofactura() {
		return lc_numerofactura;
	}
	public void setLc_numerofactura(String lc_numerofactura) {
		this.lc_numerofactura = lc_numerofactura;
	}
	public Long getTiva() {
		return tiva;
	}
	public void setTiva(Long tiva) {
		this.tiva = tiva;
	}
	public String getTipomov() {
		return tipomov;
	}
	public void setTipomov(String tipomov) {
		this.tipomov = tipomov;
	}
	
}
