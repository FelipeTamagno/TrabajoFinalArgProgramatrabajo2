/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.utn.trabajofinalargprograma;

import controlador.GestorCliente;
import controlador.GestorEspecialidad;
import controlador.GestorOperador;
import controlador.GestorReporteIncidencias;
import controlador.GestorServicio;
import controlador.GestorTecnico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Especialidad;
import modelo.OperadorMesaAyuda;
import modelo.ReporteIncidencia;
import modelo.Servicio;
import modelo.Tecnico;
import static persistencia.ConfigHibernate.load;
import vista.CargarEspecilidadesVista;
import vista.ClienteVista;
import vista.EspecialidadVista;
import vista.OperadorMesaDeAyudaVista;
import vista.ReporteDeIncidenciasVista;
import vista.ServicioVista;
import vista.TecnicoVista;

/**
 *
 * @author Gerardo
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //Identifiquese, ingrese su legajo
//            System.out.println("Seleccione la funcionalidad a ejecutar");
//            System.out.println("1- Administrar Clientes");
//            System.out.println("2- Administrar Tecnico");
//            System.out.println("3- Administrar Especialidad");
//            System.out.println("4- Administrar Operador");
//            System.out.println("5- Administrar Servicios");
//            System.out.println("6- Administrar Reporte Incidencia");
//            System.out.println("7- Reporte de incidentes por tecnico por dias ");
//            System.out.println("8- Reporte de incidentes resueltos por especialidad");
//            System.out.println("9- Reporte Estadistico Técnico mas eficiente");
//            String accion= "a";    
//            
//            while(!accion.toUpperCase().equals("R")){
//            int opcionMenu = menu();
//            if (opcionMenu == 1) {
//                GestorCliente gCliente = new GestorCliente();
//
//                System.out.println("Ingrese el cuit del cliente");
//                Long cuit = new Scanner(System.in).nextLong();
//
//                Cliente cliente = gCliente.getClienteXCUIT(cuit);
//
//                ClienteVista vistaCliente = new ClienteVista();
//
//                if (cliente == null) {
//                    System.out.println("El cliente buscado no existe. Proceda a cargar uno nuevo");
//                    cliente = vistaCliente.cargarClienteNuevo();
//                    gCliente.guardar(cliente);
//                    System.out.println("Ha agregado un nuevo cliente" + cliente.getRazonSocial());
//
//                } else {
//                    System.out.println("El cliente " + cliente.getRazonSocial() + " ya existe. Para modificar ingrese U, si desea eliminar ingrese E,"
//                            + "si desea retornar al Menu anterior presione R");
//                   accion = new Scanner(System.in).nextLine();
//                    if (accion.toUpperCase().equals("U")) {
//                        cliente = vistaCliente.modificarCliente(cliente);
//                        gCliente.guardar(cliente);
//                    } else if (accion.toUpperCase().equals("E")) {
//                        gCliente.eliminar(cliente);
//                    } else if (accion.toUpperCase().equals("R")) {
//                        System.out.println("Volvera al Menu anterior");
//                    }
//                }
//
//            } else if (opcionMenu == 2) {
//                GestorTecnico gTecnico = new GestorTecnico();
//
//                System.out.println("Ingrese el legajo del tecnico");
//                Integer legajo = new Scanner(System.in).nextInt();
//
//                Tecnico tecnico = gTecnico.getTecnicoXLegajo(legajo);
//
//                TecnicoVista vistaTecnico = new TecnicoVista();
//
//                if (tecnico == null) {
//                    System.out.println("El tecnico buscado no existe. Proceda a cargar uno nuevo");
//                    tecnico = vistaTecnico.cargarClienteNuevo(legajo);
//                    EspecialidadVista vistaEspecialidad = new EspecialidadVista();
//                    vistaEspecialidad.cargarEspecialidadesTecnico(tecnico);
//                    gTecnico.guardar(tecnico);
//                } else {
//                    System.out.println("El tecnico " + tecnico.getApellido() + " " + tecnico.getNombre() + " ya existe. Para modificar ingrese U, si desea eliminar ingrese E");
//                   accion = new Scanner(System.in).nextLine();
//                    if (accion.toUpperCase().equals("U")) {
//                        tecnico = vistaTecnico.modificarCliente(tecnico, legajo);
//                        gTecnico.guardar(tecnico);
//                    } else if (accion.toUpperCase().equals("E")) {
//                        gTecnico.eliminar(tecnico);
//                    }else if (accion.toUpperCase().equals("R")) {
//                        System.out.println("Volvera al Menu anterior");
//                    }
//                }
//            } else if (opcionMenu == 3) {
//                System.out.println("1");
//
//            }
//            }
            //obtenerConexion();
            //System.out.println("BASE DE DATOS GENERADA");
            boolean salir = false;
            while (salir != true) {
                int opcionMenu = menu();
                switch (opcionMenu) {
                    case 11:
                        System.out.println("Muchas Gracias!!!, vuelva prontos");
                        salir=true;
                        break;
                    case 1:
                        GestorCliente gCliente = new GestorCliente();

                        System.out.println("Ingrese el cuit del cliente");
                        Long cuit = new Scanner(System.in).nextLong();
                        Cliente cliente = gCliente.getClienteXCUIT(cuit);
                        ClienteVista vistaCliente = new ClienteVista();
                        if (cliente == null) {
                            System.out.println("El cliente buscado no existe. Proceda a cargar uno nuevo");
                            cliente = vistaCliente.cargarClienteNuevo();
                            gCliente.guardar(cliente);
                            System.out.println("Ha agregado un nuevo cliente" + cliente.getRazonSocial());
                        } else {
                            System.out.println("El cliente " + cliente.getRazonSocial() + " ya existe. Para modificar ingrese U, si desea eliminar ingrese E,"
                                    + "si desea retornar al Menu anterior presione R");
                            String accion = new Scanner(System.in).nextLine();
                            if (accion.toUpperCase().equals("U")) {
                                cliente = vistaCliente.modificarCliente(cliente);
                                gCliente.guardar(cliente);
                            } else if (accion.toUpperCase().equals("E")) {
                                gCliente.eliminar(cliente);
                            } else if (accion.toUpperCase().equals("R")) {
                                System.out.println("Volvera al Menu anterior");
                            }
                        }
                        break;
                    case 2:
                        GestorTecnico gTecnico = new GestorTecnico();
                        System.out.println("Ingrese el legajo del tecnico");
                        Integer legajo = new Scanner(System.in).nextInt();
                        Tecnico tecnico = gTecnico.getTecnicoXLegajo(legajo);
                        TecnicoVista vistaTecnico = new TecnicoVista();
                        Especialidad especialidadTecnico = new Especialidad();
                        CargarEspecilidadesVista espVista1 = new CargarEspecilidadesVista();
                        GestorEspecialidad geEspTecnico = new GestorEspecialidad();
                        if (tecnico == null) {
                            System.out.println("El tecnico buscado no existe. Proceda a cargar uno nuevo");
                            tecnico = vistaTecnico.cargarTecnicoNuevo(legajo);
                            EspecialidadVista vistaEspecialidad = new EspecialidadVista();
                            if (especialidadTecnico == null) {
                                Especialidad especialidad = espVista1.cargarEspecialidad();
                                geEspTecnico.guardar(especialidad);
                                vistaEspecialidad.cargarEspecialidadesTecnico(tecnico);
                                gTecnico.guardar(tecnico);
                            } else {
                                vistaEspecialidad.cargarEspecialidadesTecnico(tecnico);
                                gTecnico.guardar(tecnico);
                            }
                        } else {
                            System.out.println("El tecnico " + tecnico.getApellido() + " " + tecnico.getNombre() + " ya existe. Para modificar ingrese U,"
                                    + " si desea eliminar ingrese E, o si desea volver al menu anterior presione R");
                            System.out.println("Si desea asignar una especialidad a un Tecnico presione A");
                            String accion = new Scanner(System.in).nextLine();
                            if (accion.toUpperCase().equals("U")) {
                                tecnico = vistaTecnico.modificarTecnico(tecnico, legajo);
                                gTecnico.guardar(tecnico);
                            } else if (accion.toUpperCase().equals("E")) {
                                gTecnico.eliminar(tecnico);
                            } else if (accion.toUpperCase().equals("R")) {
                                System.out.println("Volvera al Menu anterior");
                            } else if (accion.toUpperCase().equals("A")) {
                                EspecialidadVista vistaEspecialidad = new EspecialidadVista();
                                vistaEspecialidad.cargarEspecialidadesTecnico(tecnico);
                            }
                        }
                        break;
                    case 3:
                        GestorEspecialidad geEsp = new GestorEspecialidad();
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("Desea dar de alta una Especialidad S/N, si desea modicar eliminar una especialiad presione E, o modidicar M "
                                + "presione R para volver al menú anterior");
                        String accion1 = new Scanner(System.in).nextLine();
                        CargarEspecilidadesVista espVista = new CargarEspecilidadesVista();
                        if (accion1.toUpperCase().equals("S")) {
                            Especialidad especialidad = espVista.cargarEspecialidad();
                            geEsp.guardar(especialidad);
                        } else if (accion1.toUpperCase().equals("E")) {
                            System.out.println("Ingrese el id a eliminar");
                            Long idEspecialidad = new Scanner(System.in).nextLong();
                            System.out.println("La especialidad con ese Id es " + geEsp.getEspecialidadXId(idEspecialidad).getDenominacion());
                            System.out.println("-----------------");
                            System.out.println("Desea borrar? S/N");
                            String accion2 = new Scanner(System.in).nextLine();
                            if (accion2.toUpperCase().equals("S")) {
                                geEsp.eliminar(geEsp.getEspecialidadXId(idEspecialidad));
                                System.out.println("Se elimino la especialidad seleccionada");
                            } else {
                                System.out.println("Volvera al Menu anterior");
                            }
                        }else if (accion1.toUpperCase().equals("M")){
                                System.out.println("Ingrese el id de la especialidad");
                                 Long idEspecialidad2 = new Scanner(System.in).nextLong();
                             Especialidad especialidad = espVista.modificarEspecialidad(geEsp.getEspecialidadXId(idEspecialidad2));
                             geEsp.guardar(especialidad);
                        }
                        else if (accion1.toUpperCase().equals("R")) {
                            System.out.println("Volvera al Menu anterior");
                        }
                        break;
                    case 4:
                        GestorOperador geO = new GestorOperador();
                        OperadorMesaDeAyudaVista opevista = new OperadorMesaDeAyudaVista();
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("Desea agregar un operador S/N, si desea modicar eliminar una especialiad presione E,"
                                + " o M para modificar "
                                + "presione R para volver al menú anterior");
                        String accionCase4 = new Scanner(System.in).nextLine();
                        if (accionCase4.toUpperCase().equals("S")) {
                            System.out.println("Ingrese el legajo del operador");
                            Integer legajoOperador = new Scanner(System.in).nextInt();
                            OperadorMesaAyuda ope = opevista.cargarOperadorNuevo(legajoOperador);
                            geO.guardar(ope);
                        } else if (accionCase4.toUpperCase().equals("E")) {
                            System.out.println("Ingrese el legajo del operador");
                            Integer legajoOperador = new Scanner(System.in).nextInt();
                            geO.getOperadadorXLegajo(legajoOperador);
                            System.out.println("El operador con ese legajo es: " + geO.getOperadadorXLegajo(legajoOperador).getNombreCompleto());
                            geO.eliminar(geO.getOperadadorXLegajo(legajoOperador));

                        } else if (accionCase4.toUpperCase().equals("R")) {
                            System.out.println("Volvera al Menu anterior");
                        }else if (accionCase4.toUpperCase().equals("M")){
                            System.out.println("Ingrese legajo de operador a modificar");
                             Integer legajoOperadorModificar = new Scanner(System.in).nextInt();
                            OperadorMesaAyuda opeModificar = opevista.modificarOperador(geO.getOperadadorXLegajo(legajoOperadorModificar),legajoOperadorModificar);
                            geO.guardar(opeModificar);
                        }
                        break;
                    case 5:
                        GestorServicio geS = new GestorServicio();
                        ServicioVista serVista = new ServicioVista();
                        System.out.println("Desea cargar un Servicio S/N,si desea modicar eliminar un servicio presione E,"
                                + " o M para modificar "
                                + "para volver al menu anterior preisone R ");
                        String accionCase5 = new Scanner(System.in).nextLine();
                        if (accionCase5.toUpperCase().equals("S")) {
                            Servicio servicio = serVista.cargarServicio();
                            geS.guardar(servicio);

                        } else if (accionCase5.toUpperCase().equals("E")) {
                            System.out.println("Ingrese el id a eliminar");
                            Integer legajoservicio = new Scanner(System.in).nextInt();
                            geS.eliminar(geS.getServicioXId(legajoservicio));
                            System.out.println("Se elimino el servicio " + geS.getServicioXId(legajoservicio));
                        } else if (accionCase5.toUpperCase().equals("R")) {
                            System.out.println("Volvera al Menu anterior");
                        }else if (accionCase5.toUpperCase().equals("M")){
                            System.out.println("Ingrese el Servicio a modificar");
                            System.out.println("Ingrese el id del servicio a Modificar");
                             Integer idservicio = new Scanner(System.in).nextInt();
                             Servicio serviciomodificar = serVista.modificarServicio(geS.getServicioXId(idservicio));
                             geS.guardar(serviciomodificar);
                        }
                        break;
                    case 6: ReporteIncidencia reporteIncidencia =new ReporteIncidencia();
                            GestorReporteIncidencias geReIn = new GestorReporteIncidencias();
                            ReporteDeIncidenciasVista reporteVista= new ReporteDeIncidenciasVista();
                            System.out.println("Ha elejido la opcion para reportar una incidencia");
                            System.out.println("Desea registrar un reporte de incidencia? S/N,si desea eliminar presione E");
                            String accionCase6 = new Scanner(System.in).nextLine();
                            if (accionCase6.toUpperCase().equals("S")){
                            reporteVista.cargarReporteDeIncidencias();
                            }else if (accionCase6.toUpperCase().equals("E")) {
                                System.out.println("Ingrese el codigo del reporte asignado ");
                             System.out.println("Ingrese el id a eliminar");
                            String codigoreporte = new Scanner(System.in).nextLine();
                            geReIn.getreportexCodigoReporte(codigoreporte);
                                if (geReIn.getreportexCodigoReporte(codigoreporte)==null) {
                                    System.out.println("Lo siento no se genero este codigo");
                                }else{
                                    geReIn.eliminar( geReIn.getreportexCodigoReporte(codigoreporte));
                                }    
                        }
                            break;
                    case 7:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void obtenerConexion() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");//mysql 5
            Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
            //jdbc:mysql://localhost:3306/database //mysql 5
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argentina_programa?useTimezone=true&serverTimezone=UTC", "felipe", "240313");
            if (con != null) {
                System.out.println("CONECTADO");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int menu() {
        System.out.println("Seleccione la funcionalidad a ejecutar");
        System.out.println("1- Administrar Clientes");
        System.out.println("2- Administrar Tecnico");
        System.out.println("3- Administrar Especialidad");
        System.out.println("4- Administrar Operador");
        System.out.println("5- Administrar Servicios");
        System.out.println("6- Administrar Reporte Incidencia");
        System.out.println("7- Reporte de incidentes por tecnico por dias ");
        System.out.println("8- Reporte de incidentes resueltos por especialidad");
        System.out.println("9- Reporte Estadistico Técnico mas eficiente");
        System.out.println("10- Cambiar estado de reporte");
        System.out.println("11- Salir");
        int seleccion = new Scanner(System.in).nextInt();
        return seleccion;

    }
}
