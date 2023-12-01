
package vista;

import java.util.Scanner;
import modelo.Especialidad;
import modelo.Servicio;


public class ServicioVista {
    public Servicio cargarServicio() {
        Servicio ser = new Servicio();
        System.out.println("Ingrese el Servicio a cargar");
        String denominacion = new Scanner(System.in).nextLine();
        ser.setDenominacion(denominacion);
        return ser;
    }
    
    public Servicio modificarServicio(Servicio servicio){
        System.out.println("Ingrese la el servicio a modificar");
        String denominacion = new Scanner(System.in).nextLine();
        servicio.setDenominacion(denominacion);
    
        return servicio;
    
    }
    
  
}
