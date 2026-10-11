package com.example.demo.RopaStoreValidation.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    private int total;
    private String estado;

    public Pedido() {
        this.fechaPedido = new Date();
    }

    public Pedido(Long id, Long clienteID, Date fechaPedido, int total, String estado) {
        this.id = id;
        this.clienteID = clienteID;
        this.fechaPedido = fechaPedido != null ? fechaPedido : new Date();
        this.total = total;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}