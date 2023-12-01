
package vista;

import controlador.GestorServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.ClienteServicio;
import modelo.Especialidad;
import modelo.Servicio;
import modelo.TecnicoEspecialidad;


public class CargarServicioClienteVista {
    public void asignarServicioCliente(Cliente cliente) throws Exception {
        GestorServicio geS= new GestorServicio();
        System.out.println("-----------------------");
        System.out.println("Lista de Servicios");
        
        List<Servicio> listaServicio = geS.listar(Servicio.class);
        for(Servicio serv : listaServicio){
            System.out.println(serv.getId() + " " + serv.getDenominacion());
        }
    
         List<Long> idServicio= new ArrayList<Long>();
         while(true){
            System.out.println("Seleccione el serivicio a asignar al Cliente");
            long idCliente = new Scanner(System.in).nextLong();
            if(idServicio.contains(idCliente)){
                System.out.println("La especialidad seleccionada ya fue asignada, elija otra");
                continue;
            }
            idServicio.add(idCliente);
            
            Servicio servicioAgregar = (Servicio) geS.buscarPorId(Servicio.class, idCliente);
            if(servicioAgregar != null){
                ClienteServicio cliServ = new ClienteServicio();
                cliServ.setCliente(cliente);
                cliServ.setServicio(servicioAgregar);
                
                cliente.addServicios(cliServ);
                System.out.println("El servicio " + servicioAgregar.getDenominacion() + " fue agregada exitosamente");
            }else{
                System.out.println("El id del servicio ingresado no existe");
            }
            System.out.println("Desea agregar otra especialidad?? S/N");
            String continuar = new Scanner(System.in).nextLine();
            if(!continuar.toUpperCase().equals("S")){
                break;
            }
        }
         
    
    }
}
