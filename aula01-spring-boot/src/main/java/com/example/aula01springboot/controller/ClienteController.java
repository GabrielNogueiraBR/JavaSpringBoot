package com.example.aula01springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
        // a classe ClienteController é instânciada pelo próprio SpringBoot


    // o GetMapping mapeia uma requisição HTTP ao servidor e retorna ao cliente (navegador)

    // GetMapping --> Métodos de Requisição HTTP
    // PostMapping --> Métodos de Requisição HTTP
    // DeleteMapping --> Métodos de Requisição HTTP

    @GetMapping("/cliente")
    public String getClientes(){
    return "Vai, algum dia, retornar do banco de dados todos os clientes!";
    }

    
    // GetMapping usando um mapeamento com uma variavel na requisicao

        // temos um tratamento para receber os codigos de cada cliente atraves de {codigo}

        // para receber o codigo dentro da nossa requisicao, devemos adicionar uma nova anotacao --> @PathVariable

        //@PathVariable --> 

    @GetMapping("/cliente/{codigo}")
    public String getCliente(@PathVariable int codigo){
        if(codigo>0)
            return "Vai algum dia retornar um cliente: "+ codigo;
        else
            return "Erro, codigo negativo: " + codigo;
    }
    
}