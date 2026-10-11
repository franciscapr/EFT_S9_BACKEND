package com.example.demo.RopaStoreValidation.repository;

import com.example.demo.RopaStoreValidation.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteID(Long clienteID);
}
