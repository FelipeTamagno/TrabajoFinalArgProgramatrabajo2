package vista;

import java.util.Scanner;
import modelo.DatosContacto;
import modelo.OperadorMesaAyuda;

public class OperadorMesaDeAyudaVista {

    public OperadorMesaAyuda cargarOperadorNuevo(int legajo) {
        OperadorMesaAyuda operador = new OperadorMesaAyuda();

        System.out.println("Ingrese el apellido del Operador");
        operador.setApellido(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el nombre del Operador");
        operador.setNombre(new Scanner(System.in).nextLine());
        operador.setLegajo(legajo);

        DatosContacto datosContacto = new DatosContacto();
        System.out.println("Ingrese el celular del Tecnico");
        datosContacto.setCelular(new Scanner(System.in).nextLong());
        System.out.println("Ingrese el Email del Tecnico");
        datosContacto.setEmail(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el telefono del Tecnico");
        datosContacto.setTelefono(new Scanner(System.in).nextLong());

        operador.setDatosContacto(datosContacto);

        return operador;
    }

    public OperadorMesaAyuda modificarOperador(OperadorMesaAyuda operador, int legajo) {
        System.out.println("Ingrese el apellido del Tecnico");
        operador.setApellido(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el nombre del Tecnico");
        operador.setNombre(new Scanner(System.in).nextLine());
        operador.setLegajo(legajo);

        DatosContacto datosContacto = new DatosContacto();
        System.out.println("Ingrese el celular del Tecnico");
        datosContacto.setCelular(new Scanner(System.in).nextLong());
        System.out.println("Ingrese el Email del Tecnico");
        datosContacto.setEmail(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el telefono del Tecnico");
        datosContacto.setTelefono(new Scanner(System.in).nextLong());

        operador.setDatosContacto(datosContacto);

        return operador;
    }

}
