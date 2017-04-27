package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@EntityValidator (value=biz.lcompras.validadores.VentasFelices.class
,properties = {
		@PropertyValue(name="periodo",from="yyyymm")
		,@PropertyValue(name="fecha",from="fecha")
}
)

@Table(name="COMPRASRETRASADAS"
      ,uniqueConstraints={
         @UniqueConstraint(name="CRE_FACTURA_DUPLICADA", columnNames={"CRE_PROVEEDOR_RUC","CRE_NUMEROFACTURA"})
        }
)
@Tab(properties= "yyyymm, fecha, contribuyente.cteNombre, proveedor.nombre, numeroFactura, montoTotal, montoIva10+, montoIva5+, exento+, tipomov.descripcion, estado.descripcion", defaultOrder="${yyyymm} desc,${fecha} asc")
@View(members="yyyymm,fecha,contribuyente;proveedor,proveedorRuc;"+"contabilidad [tipoiva,ctaCompradora;ctaPagadora]"+"Clasificacion [tipomov,formapago,deducible;estado]"+"Montos [exento,lcMontoBase10,montoBase5]"+"Calculados [totalGravada10,montoIva10;totalGravada5,montoIva5,montoTotal]"+"numeroFactura")
public class ComprasRetrasadas extends SuperClaseFeliz  {

	@Required
	@Range(min=0)
	@Column(length=6,nullable=false,name="CRE_PERIODO")	
	private Long yyyymm ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="CRE_FECHA")	
	@DefaultValueCalculator(CurrentDateCalculator.class)	
	private Date fecha ;

	
	
	@DescriptionsList(descriptionProperties="cteNombre",order="${cteNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_IDCONTRIB_ID", referencedColumnName="ID")
	private Contribuyente contribuyente ;
	
	
	@DescriptionsList(descriptionProperties="nombre",order="${nombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_IDPROV_ID", referencedColumnName="ID")
	private Proveedor proveedor ;
	
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_IDTIPOIVA_ID", referencedColumnName="ID")
	private TipoIva tipoiva ;
	
	@DescriptionsList(descriptionProperties="cuenta",condition="((${imputable} = 'S') AND (${codigocuenta} >= 400d) AND (${codigocuenta} <= 499d))")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_COMPRADORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaCompradora ;
	
	@DescriptionsList(descriptionProperties="cuenta",condition="((${imputable} = 'S') AND (${codigocuenta} >= 1010101d) AND (${codigocuenta} <= 1010199d)) OR ((${imputable} = 'S') AND (${codigocuenta} >= 1010301d) AND (${codigocuenta} <= 1010399d))")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_PAGADORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaPagadora ;
	
	@DescriptionsList(descriptionProperties="descripcion",condition="${quelibro}=3")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_TUTIPOMOV_ID", referencedColumnName="ID")
	private TipoMov tipomov ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_TUFORMAPAGO_ID", referencedColumnName="ID")
	private FormaPago formapago ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_TUDEDUCIBLE_ID", referencedColumnName="ID")
	private Deducible deducible ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CRE_TUESTADO_ID", referencedColumnName="ID")
	private Estado estado ;
		
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_MONTOEXENTO",scale=0)	
	private Double exento = 0.0d ;

	@Range(min=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_MONTOBASE10",scale=0)	
	private Double lcMontoBase10 = 0.0d;
	
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_MONTOBASE5",scale=0)	
	private Double montoBase5 = 0.0d ;
	
	@ReadOnly
	@Column(length=20,nullable=false,name="CRE_PROVEEDOR_RUC")
	private String proveedorRuc ;
	
	@ReadOnly
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_TOTALGRAVADA10",scale=0)	
	private Double totalGravada10 ;
	
	@ReadOnly
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_MONTOIVA10",scale=0)	
	private Double montoIva10 ;
	
	@ReadOnly
	@Range(min=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_TOTALGRAVADAS5",scale=0)	
	private Double totalGravada5 ;
	
	@ReadOnly
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_MONTOIVA5",scale=0)	
	private Double montoIva5 ;
	
	@ReadOnly
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="CRE_MONTOTOTAL",scale=0)	
	private Double montoTotal ;

	@Required
	@Pattern(regexp="^[0-9]+-+[0-9]+-+[0-9]+$",message="No es un numero tipo FACTURA NNNN-NNNNN-NNNN ")
	@Column(length=20,nullable=false,name="CRE_NUMEROFACTURA")	
	private String numeroFactura ;

	
	@Hidden
	@Column(length=4,nullable=false,name="CRE_TIPOIVA")	
	private Long lcTipoIva ;
	
	
	@Hidden
	@Column(length=10,nullable=false,name="CRE_CONTRIBUYENTE")	
	private Long lcContribuyente ;
	
	@Hidden
	@Column(length=20,nullable=false,name="CRE_NROFACT2")	
	private Long lcNroFact2 ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CRE_COMPRASALFA")	
	private String comprasAlfa ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CRE_PAGOSALFA")	
	private String pagosAlfa ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CRE_CUENTA")	
	private String cuenta ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CRE_CONTRACUENTA")	
	private String contraCuenta ;

	

	public Long getYyyymm() {
		return yyyymm;
	}
	public void setYyyymm(Long yyyymm) {
		this.yyyymm = yyyymm;
	}
	public Contribuyente getContribuyente() {
		return contribuyente;
	}
	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}
	public Long getLcContribuyente() {
		return lcContribuyente;
	}
	public void setLcContribuyente(Long lcContribuyente) {
		this.lcContribuyente = lcContribuyente;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public TipoIva getTipoiva() {
		return tipoiva;
	}
	public void setTipoiva(TipoIva tipoiva) {
		this.tipoiva = tipoiva;
	}
	public PlanCuentas getCtaCompradora() {
		return ctaCompradora;
	}
	public void setCtaCompradora(PlanCuentas ctaCompradora) {
		this.ctaCompradora = ctaCompradora;
	}
	public PlanCuentas getCtaPagadora() {
		return ctaPagadora;
	}
	public void setCtaPagadora(PlanCuentas ctaPagadora) {
		this.ctaPagadora = ctaPagadora;
	}
	public TipoMov getTipomov() {
		return tipomov;
	}
	public void setTipomov(TipoMov tipomov) {
		this.tipomov = tipomov;
	}
	public FormaPago getFormapago() {
		return formapago;
	}
	public void setFormapago(FormaPago formapago) {
		this.formapago = formapago;
	}
	public Deducible getDeducible() {
		return deducible;
	}
	public void setDeducible(Deducible deducible) {
		this.deducible = deducible;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getProveedorRuc() {
		return proveedorRuc;
	}
	public void setProveedorRuc(String proveedorRuc) {
		this.proveedorRuc = proveedorRuc;
	}
	public Double getExento() {
		return exento;
	}
	public void setExento(Double exento) {
		this.exento = exento;
	}
	public Double getLcMontoBase10() {
		return lcMontoBase10;
	}
	public void setLcMontoBase10(Double lcMontoBase10) {
		this.lcMontoBase10 = lcMontoBase10;
	}
	public Double getMontoBase5() {
		return montoBase5;
	}
	public void setMontoBase5(Double montoBase5) {
		this.montoBase5 = montoBase5;
	}
	public Double getTotalGravada10() {
		return totalGravada10;
	}
	public void setTotalGravada10(Double totalGravada10) {
		this.totalGravada10 = totalGravada10;
	}
	public Double getMontoIva10() {
		return montoIva10;
	}
	public void setMontoIva10(Double montoIva10) {
		this.montoIva10 = montoIva10;
	}
	public Double getTotalGravada5() {
		return totalGravada5;
	}
	public void setTotalGravada5(Double totalGravada5) {
		this.totalGravada5 = totalGravada5;
	}
	public Double getMontoIva5() {
		return montoIva5;
	}
	public void setMontoIva5(Double montoIva5) {
		this.montoIva5 = montoIva5;
	}
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Long getLcTipoIva() {
		return lcTipoIva;
	}
	public void setLcTipoIva(Long lcTipoIva) {
		this.lcTipoIva = lcTipoIva;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Long getLcNroFact2() {
		return lcNroFact2;
	}
	public void setLcNroFact2(Long lcNroFact2) {
		this.lcNroFact2 = lcNroFact2;
	}
	public String getComprasAlfa() {
		return comprasAlfa;
	}
	public void setComprasAlfa(String comprasAlfa) {
		this.comprasAlfa = comprasAlfa;
	}
	public String getPagosAlfa() {
		return pagosAlfa;
	}
	public void setPagosAlfa(String pagosAlfa) {
		this.pagosAlfa = pagosAlfa;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getContraCuenta() {
		return contraCuenta;
	}
	public void setContraCuenta(String contraCuenta) {
		this.contraCuenta = contraCuenta;
	}
	private void camposCalculados() {
		this.setLcTipoIva(this.tipoiva.getTivacod());
		this.setProveedorRuc(this.proveedor.getCodigo()); 
		this.setComprasAlfa(this.ctaCompradora.getCuenta());
		this.setCuenta(this.ctaCompradora.getCodigoalfa());
		this.setPagosAlfa(this.ctaPagadora.getCuenta());
		this.setContraCuenta(this.ctaPagadora.getCuenta());
		this.setLcContribuyente(this.contribuyente.getCteCodigo());
		// quito los guiones y puntos e intento convertir a Long
		try {
			this.setLcNroFact2(Long.parseLong(this.getNumeroFactura().replaceAll("-", "")));			
		} catch (Exception e) {
			this.setLcNroFact2(0L);
		}
		
		// calculo de iva
		
		if (this.getLcTipoIva().equals(2)) {
			this.setTotalGravada10(this.getLcMontoBase10());
			this.setTotalGravada5(this.getMontoBase5());
			this.setMontoIva10((double) Math.round(this.getLcMontoBase10() * 0.1d));
			this.setMontoIva5((double) Math.round(this.getMontoBase5() * 0.05d));
			this.setMontoTotal(this.getExento()+this.getTotalGravada10()+ Math.round(this.getMontoIva10())+this.getTotalGravada5()+Math.round(this.getMontoIva5()));
		} else {
			this.setTotalGravada10((double) Math.round(this.getLcMontoBase10() / 1.1d));
			this.setTotalGravada5((double) Math.round(this.getMontoBase5() / 1.05d));
			this.setMontoIva10((double) Math.round((this.getLcMontoBase10() / 1.1d ) * 0.1d));
			this.setMontoIva5((double) Math.round((this.getMontoBase5() / 1.05d) * 0.05d));
			this.setMontoTotal(this.getExento()+this.getTotalGravada10()+ Math.round(this.getMontoIva10())+this.getTotalGravada5()+Math.round(this.getMontoIva5()));
		}
	}
	@PrePersist
	private void antesDeGrabar() {
		this.camposCalculados();
	}
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
			this.camposCalculados();
	}		
	
}
