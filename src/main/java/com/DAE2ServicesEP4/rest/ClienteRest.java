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

    @GetMapping("/dni/{clienteDNI}")
    public ResponseEntity<Cliente> obtenerClienteDNI(@PathVariable String clienteDNI){
        Cliente cliente = clienteRepository.findByDni(clienteDNI);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/apellidoPaterno/{clienteApellidoPaterno}")
    public ResponseEntity<Cliente> obtenerClienteApellidoPaterno(@PathVariable String clienteApellidoPaterno){
        Cliente cliente = clienteRepository.findByApellidoPaterno(clienteApellidoPaterno);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente nuevoCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @DeleteMapping(value = "{clienteCodigo}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("clienteCodigo") int clienteCodigo){
        clienteRepository.deleteById(clienteCodigo);
        return ResponseEntity.ok(null);
    }
}
