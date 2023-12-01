
package controlador;

import modelo.Cliente;
import modelo.OperadorMesaAyuda;
import org.hibernate.Query;
import persistencia.ConfigHibernate;


public class GestorOperador extends Gestor{
 
    public GestorOperador() {
        if(sesion == null || !sesion.isOpen())
            sesion = ConfigHibernate.openSession();
    }    
     public OperadorMesaAyuda getOperadadorXLegajo(int legajo){
        try {
        
            Query consulta = sesion.createQuery("FROM OperadorMesaAyuda operador WHERE operador.legajo = :legajo");
            consulta.setParameter("legajo", legajo);

            OperadorMesaAyuda operadorMesaDeAyuda = (OperadorMesaAyuda) consulta.uniqueResult();
            return operadorMesaDeAyuda;
            
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
     }
     public OperadorMesaAyuda getOperadadorXId(int id){
        try {
        
            Query consulta = sesion.createQuery("FROM OperadorMesaAyuda operador WHERE operador.id = :id");
            consulta.setParameter("id", id);

            OperadorMesaAyuda operadorMesaDeAyuda = (OperadorMesaAyuda) consulta.uniqueResult();
            return operadorMesaDeAyuda;
            
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }  
      
        
        
    }
    
}
