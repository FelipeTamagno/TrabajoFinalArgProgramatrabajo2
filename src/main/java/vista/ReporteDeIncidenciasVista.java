package vista;

import controlador.GestorCliente;
import controlador.GestorOperador;
import controlador.GestorServicio;
import controlador.GestorTecnico;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import modelo.Cliente;
import modelo.ReporteIncidencia;
import modelo.Servicio;
import modelo.Tecnico;

public class ReporteDeIncidenciasVista {

    public ReporteIncidencia cargarReporteDeIncidencias() throws Exception {
        ReporteIncidencia reporteincedencia = new ReporteIncidencia();
        GestorOperador gesOperador = new GestorOperador();
        System.out.println("Operador Ingrese su legajo");
        int legajoOperador = new Scanner(System.in).nextInt();
        gesOperador.getOperadadorXLegajo(legajoOperador);

        if (gesOperador.getOperadadorXLegajo(legajoOperador) != null) {
            GestorCliente gesCliente = new GestorCliente();
            GestorServicio gesServicio = new GestorServicio();
            GestorTecnico gesTecnico = new GestorTecnico();
            System.out.println("---------------------------");
            System.out.println("Ingrese el cuit del cliente");
            Long cuitCliente = new Scanner(System.in).nextLong();
            Cliente cliente = gesCliente.getClienteXCUIT(cuitCliente);
            reporteincedencia.setCliente(cliente);//cliente
            System.out.println("----------------------------");
            System.out.println("Ingrese el id del servicio que desea reportar el problema");
           
            List<Servicio> listaservicio = new ArrayList<>();
           listaservicio = gesServicio.listar(Servicio.class);
            for (Servicio serLista : listaservicio) {
                System.out.println("Id "+serLista.getId()+" "+" Servicio "+serLista.getDenominacion());
            }
            int servicoCliente = new Scanner(System.in).nextInt();
            Servicio servicio = gesServicio.getServicioXId(servicoCliente);
            reporteincedencia.setServicio(servicio);//serviciodelcliente
            System.out.println("-----------------------------------");
            System.out.println("Indique el problema que tuvo del servicio " + gesServicio.getServicioXId(servicoCliente).getDenominacion());
            String descripcion = new Scanner(System.in).nextLine();
            reporteincedencia.setDescripcionProblema(descripcion);//descripcion as
            System.out.println("Ingrese el tipo de problema basico, intermedio, avanzando");
            String tipodeProblema = new Scanner(System.in).nextLine();
            reporteincedencia.setTipoProblema(tipodeProblema);//tipopproblema    
            reporteincedencia.setEstado("Pendiente");//estado
            LocalDate fechaDeAlta = LocalDate.now();
            Date fechaDate = Date.from(fechaDeAlta.atStartOfDay(ZoneId.systemDefault()).toInstant());
            reporteincedencia.setFechaAlta(fechaDate);//fechade alta
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaDate);
            if (reporteincedencia.getTipoProblema().toLowerCase().equals("basico")) {
                calendar.add(Calendar.DAY_OF_MONTH, 3);
            } else if (reporteincedencia.getTipoProblema().toLowerCase().equals("intermedio")) {
                calendar.add(Calendar.DAY_OF_MONTH, 5);
            } else if (reporteincedencia.getTipoProblema().toLowerCase().equals("avanzado")) {
                calendar.add(Calendar.DAY_OF_MONTH, 7);
            }
            Date nuevaFechaDate = calendar.getTime();
            reporteincedencia.setFechaPosibleResolucion(nuevaFechaDate);//fechaposible
            System.out.println("----------------------------------------------------");
            System.out.println("Asigne un tecnico al reporte para poder solucionar el incidente");
            System.out.println("----------------------------------------------------");
            System.out.println("Ingrese el ID");
            int legajoTecnico = new Scanner(System.in).nextInt();
            Tecnico tecnico = gesTecnico.getTecnicoXLegajo(legajoTecnico);
            reporteincedencia.setTecnico(tecnico);
            System.out.println("------------------------------------------------------");
            if (reporteincedencia.getTipoProblema().toLowerCase().equals("basico")) {
                reporteincedencia.setTiempoEstimadoResolucion(72);
            } else if (reporteincedencia.getTipoProblema().toLowerCase().equals("intermedio")) {
                reporteincedencia.setTiempoEstimadoResolucion(120);
            } else if (reporteincedencia.getTipoProblema().toLowerCase().equals("avanzado")) {
                reporteincedencia.setTiempoEstimadoResolucion(168);
            }

            System.out.println("Ingrese la observaiones del tecnico");
            String observacionesTecnico = new Scanner(System.in).nextLine();
            reporteincedencia.setObservacionesTecnico(observacionesTecnico);
            System.out.println("-------------------------------------------------");
            reporteincedencia.setCodigoReporteIncidencia(codigoDeReporte());//codigodereporte
        } else {
            System.out.println("Lo siento el operador no existe por favor registrese correctamente");
        }
        return reporteincedencia;
    }

    public String codigoDeReporte() {
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";    //Inicializamos la Variable//
        int numero;
        int forma;
        //Método para el Cálculo de Código//
        forma = (int) (aleatorio.nextDouble() * alfa.length() - 1 + 0);
        numero = (int) (aleatorio.nextDouble() * 99 + 100);
        cadena = cadena + alfa.charAt(forma) + numero;
        return cadena;

    }

    
    public ReporteIncidencia modificarReporteDeIncidencias(String codigoreporte) {
        ReporteIncidencia reporteincedencia = new ReporteIncidencia();
        GestorOperador gesOperador = new GestorOperador();
        System.out.println("Operador Ingrese su legajo");
        int legajoOperador = new Scanner(System.in).nextInt();
        gesOperador.getOperadadorXLegajo(legajoOperador);

        if (gesOperador.getOperadadorXLegajo(legajoOperador) != null) {
            GestorCliente gesCliente = new GestorCliente();
            GestorServicio gesServicio = new GestorServicio();
            GestorTecnico gesTecnico = new GestorTecnico();
            System.out.println("---------------------------");
            System.out.println("Ingrese el cuit del cliente");
            Long cuitCliente = new Scanner(System.in).nextLong();
            Cliente cliente = gesCliente.getClienteXCUIT(cuitCliente);
            reporteincedencia.setCliente(cliente);//cliente
            System.out.println("----------------------------");
            System.out.println("Ingrese el id que dese reportar el problema");
            int servicoCliente = new Scanner(System.in).nextInt();
            Servicio servicio = gesServicio.getServicioXId(servicoCliente);
            System.out.println("-----------------------------------");
            System.out.println("Indique el problema que tuvo del servicio " + gesServicio.getServicioXId(servicoCliente).getDenominacion());
            String descripcion = new Scanner(System.in).nextLine();
            reporteincedencia.setDescripcionProblema(descripcion);//descripcion as  
            System.out.println("Desea modificar el estado de la incidencia? S/N ");           
            String accionEstado = new Scanner(System.in).nextLine();
            if (accionEstado.toUpperCase().equals("S")) {
                System.out.println("Ingrese la modificacion");
                String estado = new Scanner(System.in).nextLine();
            reporteincedencia.setEstado(estado);//estado
            }
            System.out.println("Ingrese la observaciones del tecnico");
            String observacionesTecnico = new Scanner(System.in).nextLine();
            reporteincedencia.setObservacionesTecnico(observacionesTecnico);
            System.out.println("-------------------------------------------------");
          
        } else {
            System.out.println("Lo siento, el operador no existe por favor registrese correctamente");
        }
        return reporteincedencia;
    }
    
}
