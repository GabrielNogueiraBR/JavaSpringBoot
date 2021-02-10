package com.example.aula_29_10_2020_spring_boot.service;

import java.util.List;
import java.util.Optional;

import com.example.aula_29_10_2020_spring_boot.model.Cliente;
import com.example.aula_29_10_2020_spring_boot.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repository;

    public List<Cliente> getAllClientes(){
        return repository.getAllClientes();
    }

    public Cliente getClienteByCodigo(int codigo){
        Optional<Cliente> op = repository.getClienteByCodigo(codigo);
        return op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao cadastrado"));
    }
}
