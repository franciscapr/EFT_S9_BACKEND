package com.example.demo.RopaStoreValidation.controller;

import com.example.demo.RopaStoreValidation.model.*;
import com.example.demo.RopaStoreValidation.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

   private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/cliente/{clienteID}")
    public List<Pedido> obtenerPorCliente(@PathVariable Long clienteID) {
        return pedidoService.listarPorCliente(clienteID);
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.crearPedido(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido actualizado = pedidoService.modificarPedido(id, pedido);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        return pedidoService.eliminarPedido(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
