package com.example.aula01springboot.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

//Importacao do pacote que possui a classe cliente
import com.example.aula01springboot.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
        // a classe ClienteController é instânciada pelo próprio SpringBoot

    //Criando uma lista para armazenar nossos objetos a serem passados para o método GetMapping
        //Essa lista é um ATRIBUTO da classe ClienteController, ele seria variavel caso estivesse dentro de um método.

    List <Cliente> listaCliente;
        // listaCliente = new ArrayList<Cliente>(); --> cria a Lista
    
    //Todos os métodos enxergam o atributo, diferente de uma variavel
        //Atributo -> Dentro da classe
        //Variavel -> Dentro de um método


    //PostConstruct é uma anotação do Java que chama o método que possui a anotação assim que a classe é construída.

    @PostConstruct
    public void criarClientes(){
        //Metodo para criar Clientes
        final Cliente c1 = new Cliente();
        final Cliente c2 = new Cliente();
        final Cliente c3 = new Cliente();

        c1.codigo = 1;
        c1.nome = "Jose";
        c1.endereco = "Rua X, 97";
        c1.saldo = 100;

        c2.codigo = 2;
        c2.nome = "Maria";
        c2.endereco = "Rua Y, 98";
        c2.saldo = 300;

        c3.codigo = 3;
        c3.nome = "Pedro";
        c3.endereco = "Rua Z, 99";
        c3.saldo = 400;

        // Adicionando vários itens de uma vez na Lista
        listaCliente = Arrays.asList(c1, c2, c3);
        // com o asList, podemos inserir quantos objetos quisermos daquele tipo
        // asList(T...a) sendo o T o tipo da Classe que corresponde a Lista criada

        // Adicionando item a item na Lista
        // listaCliente.add(new Cliente());

    }

    // o GetMapping mapeia uma requisição HTTP ao servidor e retorna ao cliente
    // (navegador)

    // GetMapping --> Métodos de Requisição HTTP
    // PostMapping --> Métodos de Requisição HTTP
    // DeleteMapping --> Métodos de Requisição HTTP

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return listaCliente;
    }

    // GetMapping usando um mapeamento com uma variavel na requisicao

    // temos um tratamento para receber os codigos de cada cliente atraves de
    // {codigo}

    // para receber o codigo dentro da nossa requisicao, devemos adicionar uma nova
    // anotacao --> @PathVariable

    // @PathVariable -->

    @GetMapping("/cliente/{codigo}")
    public Cliente getCliente(@PathVariable final int codigo) {
        Cliente cli;

        // Primeiro modo sem as orientações do professor
        final int position = getPosition(codigo);
        if (codigo > 0 && position > -1) {
            cli = listaCliente.get(position);
        } else
            cli = null;

        // Segundo Modo de retornar com as orientações do professor
        cli = getClienteCodigo(codigo);

        return cli;

    }

    public int getPosition(final int codigo) {
        int i;

        for (i = 0; i < listaCliente.size(); i++) {

            if (this.listaCliente.get(i).codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    // Metodo criado a partir da explicacao do professor
    public Cliente getClienteCodigo(final int codigo) {
        for (final Cliente aux : listaCliente) {

            if(aux.codigo == codigo)
                return aux;

        }
        return null;

    }
}