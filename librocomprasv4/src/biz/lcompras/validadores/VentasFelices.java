package biz.lcompras.validadores;


import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;

public class VentasFelices implements IValidator {

	/**
	 * el periodo YYYYMM debe coincidir con mes anho de la fecha
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje ;
	private Long periodo ;
	private Date fecha;
	private Calendar micalendario  = Calendar.getInstance() ;
	@Override
	public void validate(Messages errors) throws Exception {
		this.setMensaje("No coincide YYYYMM con la fecha ");
		this.micalendario.setTime(fecha);
		int anho = micalendario.get(Calendar.YEAR) ;
		int mes = micalendario.get(Calendar.MONTH) + 1 ;
		Long anomes =(long) ((anho  * 100) + mes) ;
		
		String anomesfeliz = anomes.toString();
		String periodofeliz = periodo.toString();
		
		if ( !anomes.equals(periodo) ) {
			errors.add(this.getMensaje()+ anomesfeliz + " <--> " + periodofeliz);
		}
		
	}

	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public Long getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Calendar getMicalendario() {
		return micalendario;
	}


	public void setMicalendario(Calendar micalendario) {
		this.micalendario = micalendario;
	}



	
	
}
