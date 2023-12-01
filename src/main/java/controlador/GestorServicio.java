
package controlador;

import modelo.Especialidad;
import modelo.Servicio;
import org.hibernate.Query;
import persistencia.ConfigHibernate;


public class GestorServicio extends Gestor {

    public GestorServicio() {
          if (sesion == null || !sesion.isOpen()) {
            sesion = ConfigHibernate.openSession();
        }
    }
    public Servicio getServicioXId(Integer idServicio) {
        try {

            Query consulta = sesion.createQuery("FROM servicio WHERE id = :idServicio");
            consulta.setParameter("idServicio", idServicio);

            Servicio servicio = (Servicio) consulta.uniqueResult();
            return servicio;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    
}
