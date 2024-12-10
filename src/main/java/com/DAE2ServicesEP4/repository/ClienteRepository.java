package com.DAE2ServicesEP4.repository;

import com.DAE2ServicesEP4.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findAll();
    Cliente findByDni(String dni);
    Cliente findByApellidoPaterno(String apellidoPaterno);
    void deleteById(int id);
}
