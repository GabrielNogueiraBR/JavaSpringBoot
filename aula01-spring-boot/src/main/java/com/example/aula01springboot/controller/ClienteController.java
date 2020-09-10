package com.example.aula01springboot.controller;

import java.util.List;

//Importacao do pacote que possui a classe cliente
import com.example.aula01springboot.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula01springboot.repository.*;

@RestController
public class ClienteController {
        // a classe ClienteController é instânciada pelo próprio SpringBoot
    
    @Autowired
    private ClienteRepository repository;

    // o GetMapping mapeia uma requisição HTTP ao servidor e retorna ao cliente
    // (navegador)

    // GetMapping --> Métodos de Requisição HTTP
    // PostMapping --> Métodos de Requisição HTTP
    // DeleteMapping --> Métodos de Requisição HTTP

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return repository.getAllClientes();
    }

    // GetMapping usando um mapeamento com uma variavel na requisicao

    // temos um tratamento para receber os codigos de cada cliente atraves de
    // {codigo}

    // para receber o codigo dentro da nossa requisicao, devemos adicionar uma nova
    // anotacao --> @PathVariable

    // @PathVariable -->

    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable final int codigo) {
        return repository.getClienteByCodigo(codigo);
    }



    //PostMapping é usado para enviar informacoes atraves do body da mensagem para o servidor
    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.saveCliente(cliente);
    }
}