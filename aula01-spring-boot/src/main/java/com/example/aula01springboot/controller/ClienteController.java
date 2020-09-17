package com.example.aula01springboot.controller;

import java.net.URI;
import java.util.List;

//Importacao do pacote que possui a classe cliente
import com.example.aula01springboot.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Cliente> getCliente(@PathVariable final int codigo) {
        //ResponseEntity<Cliente> pois no corpo da resposta e passado informacoes de cliente
        Cliente cliente = repository.getClienteByCodigo(codigo);
        if( cliente != null){
            return ResponseEntity.ok(cliente);
        }
        else
            return ResponseEntity.notFound().build();
        
    }



    //PostMapping é usado para enviar informacoes atraves do body da mensagem para o servidor
    @PostMapping("/clientes")
    public ResponseEntity<Void> salvar(@RequestBody Cliente cliente){
        //ResponseEntity<Void> pois no corpo da resposta nenhuma informacao e mostrada, por isso utilizamos o void dentro do response entity.
        
        cliente = repository.saveCliente(cliente);

        URI uri;
        uri = URI.create("http://localhost:8080/clientes/" + cliente.getCodigo());       
        return ResponseEntity.created(uri).build();

    }


    //DeleteMapping é usado para remover clientes do nosso repositório (BD)
    @DeleteMapping("/clientes/{codigo}")
    public ResponseEntity<Void> remove(@PathVariable final int codigo){
        Cliente cliente = repository.getClienteByCodigo(codigo);

        if( cliente != null){
            repository.remover(cliente);     
            return ResponseEntity.noContent().build(); // código 204 para remoção bem sucedida
        }
        else{
            return ResponseEntity.notFound().build(); // código 404 quando o cliente não é encontrado
        }

    }

    //PutMapping é utilizado para atualizar informaçoes da nossa base de dados
    @PutMapping("/clientes/{codigo}")
    public ResponseEntity<Cliente> autalizar(@PathVariable int codigo, @RequestBody Cliente cliente)
    {
        //@PathVariable pega o {codigo} e passa para a requisição como codigo

        //@RequestBody pega um Cliente do corpo da requisição para ser enviado para atualizar as informações

        if(repository.getClienteByCodigo(codigo) != null)
        {
            cliente.setCodigo(codigo);
            cliente = repository.update(cliente);
            return ResponseEntity.ok(cliente);

        }
        else
            return ResponseEntity.notFound().build();
            
    }

}