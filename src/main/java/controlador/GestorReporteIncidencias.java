
package controlador;

import java.util.Date;
import java.util.List;
import modelo.Cliente;
import modelo.ReporteIncidencia;
import org.hibernate.Query;
import persistencia.ConfigHibernate;


public class GestorReporteIncidencias extends Gestor {
     public GestorReporteIncidencias() {
        if(sesion == null || !sesion.isOpen())
            sesion = ConfigHibernate.openSession();
    }
     
 public ReporteIncidencia getreportexCodigoReporte(String codigoReporteIncidencia){
     //usar para dar al cliente el codigo de su reporte
        try {
        
            Query consulta = sesion.createQuery("FROM ReporteIncidencia reporte WHERE reporte.cuit = :cuit");
            consulta.setParameter("cuit", codigoReporteIncidencia);

            ReporteIncidencia reporteIncidecia = (ReporteIncidencia) consulta.uniqueResult();
            return reporteIncidecia;
            
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
 
 public List<Object> getTecnicoQuemasResolvioProblemas(Date fechaDesde,Date fechaHasta){
    
     Query consulta = sesion.createQuery("SELECT apri.idtecnico, COUNT(*) FROM ArgentinaProgamaReporteIncidencia apri"+ 
    "WHERE apri.fechaDesde >= :fechadesde AND apri.fechaDesde <= :fechaIngresada"+ 
    "AND apri.estado = 'resuelto' GROUP BY apri.idtecnico");
           
            consulta.setDate("fechadesde", fechaDesde);
            consulta.setDate("fechahasta", fechaHasta);
            
            ReporteIncidencia reporteincidencia = (ReporteIncidencia) consulta.setMaxResults(1);
         return (List<Object>) reporteincidencia;
     
 
 
 }
 
    
}
