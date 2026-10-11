package com.example.demo.RopaStoreValidation.service;

import com.example.demo.RopaStoreValidation.model.*;
import com.example.demo.RopaStoreValidation.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


  private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //listar todos

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    //buscar por rut
    public Optional<Cliente> buscarPorRut(String rut) {
        return clienteRepository.findByRut(rut);
    }

    //crear un cliente

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //modificar un cliente

    public Cliente modificarCliente(Long id, Cliente datos) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(datos.getNombre());
            cliente.setRut(datos.getRut());
            cliente.setCorreo(datos.getCorreo());
            cliente.setTelefono(datos.getTelefono());
            cliente.setDireccion(datos.getDireccion());
            return clienteRepository.save(cliente);
        }).orElse(null);
    }

    //eliminar un cliente

    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
