package com.DAE2ServicesEP4.rest;

import com.DAE2ServicesEP4.entity.Cliente;
import com.DAE2ServicesEP4.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "cliente")
public class ClienteRest {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        List<Cliente> listaClientes = clienteRepository.findAll();
        return ResponseEntity.ok(listaClientes);
    }

    @RequestMapping(value = "{clienteDNI}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable String clienteDNI){
        Cliente cliente = clienteRepository.findByDni(clienteDNI);
        return ResponseEntity.ok(cliente);
    }

    @RequestMapping(value = "{clienteApellidoPaterno}")
    public ResponseEntity<Cliente> obtenerClienteApellidoPaterno(@PathVariable String clienteApellidoPaterno){
        Cliente cliente = clienteRepository.findByApellidoPaterno(clienteApellidoPaterno);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente nuevoCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @DeleteMapping(value = "{clienteId}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("clienteId") int clienteId){
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.ok(null);
    }
}
