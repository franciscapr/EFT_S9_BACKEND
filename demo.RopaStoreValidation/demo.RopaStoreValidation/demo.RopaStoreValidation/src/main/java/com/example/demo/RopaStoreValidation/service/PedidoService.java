package com.example.demo.RopaStoreValidation.service;

import com.example.demo.RopaStoreValidation.model.*;
import com.example.demo.RopaStoreValidation.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //listar todos

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    //listar por clienteId

    public List<Pedido> listarPorCliente(Long clienteID) {
        return pedidoRepository.findByClienteID(clienteID);
    }

    //crear un pedido

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //modificar un pedido

    public Pedido modificarPedido(Long id, Pedido datos) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setClienteID(datos.getClienteID());
            pedido.setTotal(datos.getTotal());
            pedido.setEstado(datos.getEstado());
            return pedidoRepository.save(pedido);
        }).orElse(null);
    }

    //eliminar un pedido

    public boolean eliminarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}