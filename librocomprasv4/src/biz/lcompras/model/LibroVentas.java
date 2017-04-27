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
				@PropertyValue(name="periodo",from="lvPeriodo")
				,@PropertyValue(name="fecha",from="lvFecha")
		}
		)
@Table(name="LIBROVENTAS"
	,uniqueConstraints={
        @UniqueConstraint(name="LVE_FACTURA_DUPLICADA", columnNames={"LV_CLIENTE_RUC","LV_NUMEROFACTURA"})
        }
)
@Tab(properties="lvPeriodo,lvFecha,contribuyente.cteNombre,cliente.cliNombre,lvNumeroFactura,lvMontoTotal+,lvMontoIva10+,lvMontoIva5+,lvExento+,tipomov.descripcion,estado.descripcion",defaultOrder="${lvPeriodo} desc,${lvFecha} asc")
@View(members="lvPeriodo,lvFecha,lvNumeroFactura;cliente,lvClienteRuc;contribuyente;"+"Contabilidad [tipoiva,tipomov;formapago,estado;ctaVendedora,ctaCobradora];"+";lvExento,lvMontoBase10,lvMontoBase5;"+"Totales [totalGravada10,lvMontoIva10;totalGravadas5,lvMontoIva5,lvMontoTotal]")
public class LibroVentas extends SuperClaseFeliz  {
	@Required
	@Min(0)
	@Column(length=6,nullable=false,name="LV_PERIODO")	
	private Long lvPeriodo ;	
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="LV_FECHA")	
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date lvFecha ;
	
	@DescriptionsList(descriptionProperties="cliNombre",order="${cliNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCLI_ID", referencedColumnName="ID")
	private Cliente cliente ;		
	
	@DescriptionsList(descriptionProperties="cteNombre",order="${cteNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCONTRIB_ID", referencedColumnName="ID")
	private Contribuyente contribuyente ;
	
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDTIPOIVA_ID", referencedColumnName="ID")
	private TipoIva tipoiva ;

	@DescriptionsList(descriptionProperties="descripcion",condition="${quelibro}=1")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUTIPOMOV_ID", referencedColumnName="ID")
	private TipoMov tipomov ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUFORMACOBRO_ID", referencedColumnName="ID")
	private FormaPago formapago ;	
	
	@DescriptionsList(descriptionProperties="cuenta",condition="((${imputable} = 'S') AND (${codigocuenta} >= 1011001d) AND (${codigocuenta} <= 1011099d)) OR ((${imputable} = 'S') AND (${codigocuenta} >= 301d) AND (${codigocuenta} <= 302d)) ")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="VENDEDORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaVendedora ;	
	
	@DescriptionsList(descriptionProperties="cuenta",condition="(${imputable} = 'S') AND (${codigocuenta} >= 1010101d) AND (${codigocuenta} <= 1010199d)")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="COBRADORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaCobradora ;		
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUESTADO_ID", referencedColumnName="ID")
	private Estado estado ;
	
	
	@Column(length=20,nullable=false,name="LV_CLIENTE_RUC")
	@ReadOnly	
	private String lvClienteRuc ;
	
	@Hidden
	@Column(length=10,nullable=false,name="LV_CONTRIBUYENTE")
	private Long lvContribuyente ;
	
	@Range(min=0)	
	@Column(length=20,nullable=false,name="LV_MONTOEXENTO",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double lvExento ;

	@Range(min=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="LV_MONTOBASE10",scale=0)	
	private Double lvMontoBase10 ;
	
	@Range(min=0)
	@Column(length=20,nullable=false,name="LV_MONTOBASE5",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double lvMontoBase5 ;	
	
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADA10",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double totalGravada10 ;
	
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_MONTOIVA10",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double lvMontoIva10 ;
	
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADAS5",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double totalGravadas5 ;
	
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_MONTOIVA5",scale=0)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double lvMontoIva5 ;
	
	@ReadOnly
	@DefaultValueCalculator(CeroFelizDouble.class)
	@Column(length=20,nullable=false,name="LV_MONTOTOTAL",scale=0)	
	private Double lvMontoTotal ;
	
	@Hidden
	@Column(length=4,nullable=false,name="LV_TIPOIVA")	
	private Long lvTipoIva ;
	
	@Required
	@Pattern(regexp="^[0-9]+-+[0-9]+-+[0-9]+$",message="No es FACTURA NNNNN-NNNN-NNN ")
	@Column(length=20,nullable=false,name="LV_NUMEROFACTURA")	
	private String lvNumeroFactura ;
	
	@Hidden
	@Column(length=20,nullable=false,name="LV_NROFACT2")	
	private Long lvNroFact2 ;
	
	@Hidden
	@Column(length=200,nullable=false,name="VENTASALFA")	
	private String ventasAlfa ;
	
	@Hidden
	@Column(length=200,nullable=false,name="COBROSALFA")	
	private String cobrosAlfa ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CUENTA")	
	private String cuenta ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CONTRACUENTA")	
	private String contraCuenta ;



	public Long getLvPeriodo() {
		return lvPeriodo;
	}
	public void setLvPeriodo(Long lvPeriodo) {
		this.lvPeriodo = lvPeriodo;
	}
	public Date getLvFecha() {
		return lvFecha;
	}
	public void setLvFecha(Date lvFecha) {
		this.lvFecha = lvFecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Contribuyente getContribuyente() {
		return contribuyente;
	}
	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}
	public TipoIva getTipoiva() {
		return tipoiva;
	}
	public void setTipoiva(TipoIva tipoiva) {
		this.tipoiva = tipoiva;
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
	public PlanCuentas getCtaVendedora() {
		return ctaVendedora;
	}
	public void setCtaVendedora(PlanCuentas ctaVendedora) {
		this.ctaVendedora = ctaVendedora;
	}
	public PlanCuentas getCtaCobradora() {
		return ctaCobradora;
	}
	public void setCtaCobradora(PlanCuentas ctaCobradora) {
		this.ctaCobradora = ctaCobradora;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getLvClienteRuc() {
		return lvClienteRuc;
	}
	public void setLvClienteRuc(String lvClienteRuc) {
		this.lvClienteRuc = lvClienteRuc;
	}
	public Long getLvContribuyente() {
		return lvContribuyente;
	}
	public void setLvContribuyente(Long lvContribuyente) {
		this.lvContribuyente = lvContribuyente;
	}
	public Double getLvExento() {
		return lvExento;
	}
	public void setLvExento(Double lvExento) {
		this.lvExento = lvExento;
	}
	public Double getLvMontoBase10() {
		return lvMontoBase10;
	}
	public void setLvMontoBase10(Double lvMontoBase10) {
		this.lvMontoBase10 = lvMontoBase10;
	}
	public Double getLvMontoBase5() {
		return lvMontoBase5;
	}
	public void setLvMontoBase5(Double lvMontoBase5) {
		this.lvMontoBase5 = lvMontoBase5;
	}
	public Double getTotalGravada10() {
		return totalGravada10;
	}
	public void setTotalGravada10(Double totalGravada10) {
		this.totalGravada10 = totalGravada10;
	}
	public Double getLvMontoIva10() {
		return lvMontoIva10;
	}
	public void setLvMontoIva10(Double lvMontoIva10) {
		this.lvMontoIva10 = lvMontoIva10;
	}
	public Double getTotalGravadas5() {
		return totalGravadas5;
	}
	public void setTotalGravadas5(Double totalGravadas5) {
		this.totalGravadas5 = totalGravadas5;
	}
	public Double getLvMontoIva5() {
		return lvMontoIva5;
	}
	public void setLvMontoIva5(Double lvMontoIva5) {
		this.lvMontoIva5 = lvMontoIva5;
	}
	public Double getLvMontoTotal() {
		return lvMontoTotal;
	}
	public void setLvMontoTotal(Double lvMontoTotal) {
		this.lvMontoTotal = lvMontoTotal;
	}
	public Long getLvTipoIva() {
		return lvTipoIva;
	}
	public void setLvTipoIva(Long lvTipoIva) {
		this.lvTipoIva = lvTipoIva;
	}
	public String getLvNumeroFactura() {
		return lvNumeroFactura;
	}
	public void setLvNumeroFactura(String lvNumeroFactura) {
		this.lvNumeroFactura = lvNumeroFactura;
	}
	public Long getLvNroFact2() {
		return lvNroFact2;
	}
	public void setLvNroFact2(Long lvNroFact2) {
		this.lvNroFact2 = lvNroFact2;
	}
	public String getVentasAlfa() {
		return ventasAlfa;
	}
	public void setVentasAlfa(String ventasAlfa) {
		this.ventasAlfa = ventasAlfa;
	}
	public String getCobrosAlfa() {
		return cobrosAlfa;
	}
	public void setCobrosAlfa(String cobrosAlfa) {
		this.cobrosAlfa = cobrosAlfa;
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
		this.setLvTipoIva(this.tipoiva.getTivacod());
		this.setLvClienteRuc(this.cliente.getCliCodigo());
		this.setVentasAlfa(this.ctaVendedora.getCuenta());
		this.setCuenta(this.ctaVendedora.getCodigoalfa());
		this.setCobrosAlfa(this.ctaCobradora.getCuenta());
		this.setContraCuenta(this.ctaCobradora.getCuenta());
		this.setLvContribuyente(this.contribuyente.getCteCodigo());

		// quito los guiones y puntos e intento convertir a Long
		try {
			this.setLvNroFact2(Long.parseLong(this.getLvNumeroFactura().replaceAll("-", "")));			
		} catch (Exception e) {
			this.setLvNroFact2(0L);
		}
		Long ivadiscriminado = 2L ;
		if (this.getLvTipoIva() == ivadiscriminado) {
			this.setTotalGravada10(this.getLvMontoBase10());
			this.setTotalGravadas5(this.getLvMontoBase5());
			this.setLvMontoIva10((double) Math.round(this.getLvMontoBase10() * 0.1d));
			this.setLvMontoIva5((double) Math.round(this.getLvMontoBase5() * 0.05d));
			this.setLvMontoTotal(this.getLvExento()+this.getTotalGravada10()+ Math.round(this.getLvMontoIva10())+this.getTotalGravadas5()+Math.round(this.getLvMontoIva5()));
		} else {
			this.setTotalGravada10((double) Math.round(this.getLvMontoBase10() / 1.1d));
			this.setTotalGravadas5((double) Math.round(this.getLvMontoBase5() / 1.05d));
			this.setLvMontoIva10((double) Math.round((this.getLvMontoBase10() / 1.1d ) * 0.1d));
			this.setLvMontoIva5((double) Math.round((this.getLvMontoBase5() / 1.05d) * 0.05d));
			this.setLvMontoTotal(this.getLvExento()+this.getTotalGravada10()+ Math.round(this.getLvMontoIva10())+this.getTotalGravadas5()+Math.round(this.getLvMontoIva5()));			
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
