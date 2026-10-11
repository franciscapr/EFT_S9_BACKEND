package com.example.demo.RopaStoreValidation.service;

import com.example.demo.RopaStoreValidation.model.*;
import com.example.demo.RopaStoreValidation.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Listar todos
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    // Buscar por Id
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Listar por sucursal
    public List<Producto> listarPorSucursal(Long sucursalID) {
        return productoRepository.findBySucursalID(sucursalID);
    }

    // Crear un producto nuevo
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Modificar un producto
    public Producto modificarProducto(Long id, Producto productoDetalles) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoDetalles.getNombre());
            producto.setPrecio(productoDetalles.getPrecio());
            producto.setCategoria(productoDetalles.getCategoria());
            producto.setStock(productoDetalles.getStock());
            producto.setSucursalID(productoDetalles.getSucursalID());
            return productoRepository.save(producto);
        }).orElse(null);
    }

    // Eliminar un producto
    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}