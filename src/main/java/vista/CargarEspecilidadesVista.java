package vista;

import java.util.Scanner;
import modelo.Especialidad;

public class CargarEspecilidadesVista {

    public Especialidad cargarEspecialidad() {
        Especialidad esp = new Especialidad();
        System.out.println("Ingrese la especialidad a cargar");
        String denominacion = new Scanner(System.in).nextLine();
        esp.setDenominacion(denominacion);
        return esp;
    }

     public Especialidad modificarEspecialidad(Especialidad especialidad) {
       
        System.out.println("Ingrese la especialidad a Modificar");
        String denominacion = new Scanner(System.in).nextLine();
        especialidad.setDenominacion(denominacion);
        return especialidad;
    }
    
}
