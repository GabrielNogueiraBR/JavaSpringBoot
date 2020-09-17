package com.example.aula01springboot.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.aula01springboot.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    private List <Cliente> listaCliente;
    private int nextId = 0;
    //PostConstruct é uma anotação do Java que chama o método que possui a anotação assim que a classe é construída.
    @PostConstruct
    public void criarClientes(){
        //Metodo para criar Clientes
        final Cliente c1 = new Cliente();
        final Cliente c2 = new Cliente();
        final Cliente c3 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X, 97");
        c1.setSaldo(100);
     
        c2.setCodigo(2);
        c2.setNome("Maria");
        c2.setEndereco("Rua Y, 98");
        c2.setSaldo(300);

        c3.setCodigo(3);
        c3.setNome("Pedro");
        c3.setEndereco("Rua Z, 99");
        c3.setSaldo(400);
    
        // Criação de Lista
        listaCliente = new ArrayList<Cliente>();
        listaCliente.add(c1);
        listaCliente.add(c2);
        listaCliente.add(c3);

        nextId = 4;
    }


    public List<Cliente> getAllClientes(){
        return listaCliente;
    }

    public Cliente getClienteByCodigo(int codigo){
        
        for(Cliente auxCliente: listaCliente){
            if(auxCliente.getCodigo() == codigo)
            {
                return auxCliente;
            }
        }

        return null;
    }

    public Cliente saveCliente(Cliente cliente){

        cliente.setCodigo(nextId++);
        listaCliente.add(cliente);
        return cliente;

    }


	public void remover(Cliente cliente) {

        listaCliente.remove(cliente); //remoção do cliente passado por parâmetro

	}

}
