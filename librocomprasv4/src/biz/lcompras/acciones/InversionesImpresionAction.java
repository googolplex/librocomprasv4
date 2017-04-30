package biz.lcompras.acciones;


import java.sql.*;
import java.util.*;
import org.openxava.actions.*;
import org.openxava.util.*;

import biz.lcompras.beansfelices.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.engine.fill.*;
import org.apache.commons.dbutils.BeanProcessor;


public class InversionesImpresionAction  extends JasperReportBaseAction {


	Connection con = null ;
	Collection<VistaInversionesImpresionBean> miColeccion = null;	
	JRBeanCollectionDataSource beanColDataSource = null ;
	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		
		// java.util.Vector miColeccion = null ;

		// return new JREmptyDataSource();
		// si le devuelves null se le devuelve la conexion JDBC, para usar el SQL dentro del reporte
		// http://www.openxava.org/OpenXavaDoc/apidocs/org/openxava/actions/JasperReportBaseAction.html#getDataSource()
		
		// String table = MetaModel.get("InvoiceDetail").getMapping().getTable();
		// porque no es una tabla
		try {
		con = DataSourceConnectionProvider.getByComponent("InversionesInforme").getConnection();		
		PreparedStatement ps = con.prepareStatement("select * from vista_inversiones_periodos_contribuyentes k order by tipomov, lc_fecha");
		ResultSet rs = ps.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		ArrayList<VistaInversionesImpresionBean> listafeliz = new ArrayList<VistaInversionesImpresionBean>();		
		while(rs.next()) {
			listafeliz.add((VistaInversionesImpresionBean) bp.toBean(rs, VistaInversionesImpresionBean.class));
		}
        rs.close();
        ps.close();
        // solo para debug
        
        // para listar arrays por la consola
        // for(VistaLibroComprasBean mb : listafeliz){
        //    System.out.println(mb.getLc_numerofactura());
        // }        
        // http://stackoverflow.com/questions/22340535/how-to-show-jrbeancollectiondatasource-data-in-ireport-table
        
        miColeccion = listafeliz ;  
        		        
		} catch (Exception e ){
			e.printStackTrace();
		}
		
		// return null;
		
		// para lista colecciones por la consola
        // for(VistaLibroComprasBean mb : miColeccion){
        //    System.out.println(mb.getLc_numerofactura());
        //	}
		
        beanColDataSource = new JRBeanCollectionDataSource(miColeccion);
        
		return beanColDataSource ;
	}

	public void execute() throws Exception {
		super.execute();
		addMessage("Impresion del Libro");
	}	
	
	
	@Override
	protected String getJRXML() throws Exception {
		// return "/home/xoldfusion/Descargas/librocompras2017/jasperfeliz/prueba3.jrxml" ; // lo leo del file system
		// return "biz/lcompras/informes/prueba3.jrxml"; // lo leo del classpath 

		// return "biz/lcompras/informes/inversionesimpresionpg1.jrxml"; // lo leo del classpath
		return "biz/lcompras/informes/inversionespgbeans.jrxml"; // lo leo del classpath
	}

	@Override
	protected Map<String, Object> getParameters() throws Exception {
		JRFileVirtualizer virtualizer = new JRFileVirtualizer(2, "/tmp");
				
		Map<String, Object> parametros = new HashMap<String, Object>() ;
		parametros.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);

//		parametros.put(JRParameter.REPORT_CONNECTION, con );
		
		// yo creo que no se va a usar porque tengo la clase donde pongo los parametros
		// parametros.put("p_yyyymm","201701");
		// parametros.put("p_contribuyente","581069");
		// parametros.put("REPORT_CONNECTION", "jdbc:postgresql://52.207.31.88:5432/manzanas?user=manzanas&password=googolplex124abc");
		//		return null ;
		return parametros ;
	}

	
	
/*	public Collection<VistaLibroCompras> getRenglones() {
		if (renglones == null ) {
			renglones = XPersistence.getManager().createQuery("from VistaLibroCompras").getResultList();
		}
		return renglones;
	}*/


	
	
}
