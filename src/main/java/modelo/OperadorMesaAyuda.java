/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gerardo
 */
@Entity
@Table(name = "arg_prog_operador_mesa_ayuda")
@Getter
@Setter
public class OperadorMesaAyuda extends Empleado {

     @OneToMany(mappedBy = "operador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReporteIncidencia> reportesIncidencia;//1 a N
    
    
    public OperadorMesaAyuda(String apellido, String nombre, int legajo, DatosContacto datosContacto) {
        super(apellido, nombre, legajo, datosContacto);
    }

    public OperadorMesaAyuda() {
    }

}
