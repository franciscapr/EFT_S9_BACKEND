package com.example.demo.RopaStoreValidation.repository;

import com.example.demo.RopaStoreValidation.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findBySucursalID(Long sucursalID);
}