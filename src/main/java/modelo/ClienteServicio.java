/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gerardo
 */
@Entity
@Table(name = "arg_prog_cliente_servicio")
@Getter @Setter
public class ClienteServicio extends EntidadId implements Comparable<ClienteServicio>{

    public ClienteServicio(Cliente cliente, Servicio servicio) {
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public ClienteServicio() {
    }
    
    
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idservicio")
    private Servicio servicio;

    @Override
    public int compareTo(ClienteServicio t) {
       return new Long(this.cliente.getId()).compareTo(t.getCliente().getId()); 
    }
}
