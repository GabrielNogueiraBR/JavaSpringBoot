package com.example.aula_29_10_2020_spring_boot.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import com.example.aula_29_10_2020_spring_boot.model.Cliente;
import com.example.aula_29_10_2020_spring_boot.model.Pedido;
import com.example.aula_29_10_2020_spring_boot.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PedidoService {
    

    @Autowired
    private PedidoRepository repository;


    @Autowired
    private ClienteService clienteService;


    public List<Pedido> getAllPedidos(){
        return repository.getAllPedidos();
    }

    public Pedido getPedidoByNumero(long numero){
        Optional <Pedido> op = repository.getPedidoByNumero(numero);
        return op.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido nao cadastrado"));
    }

    public Pedido salvar(Pedido pedido, int codigo){
        
        //verifica se existe um cliente com o codigo recebido
        //se NAO existir, lanca o 404 Not Found e nao executa as demais linhas do salvar
        Cliente cliente = clienteService.getClienteByCodigo(codigo);

        //associar um pedido com cliente e o cliente com o pedido
        pedido.setCliente(cliente);
        cliente.addPedido(pedido);

        return repository.salvar(pedido);
    }
}
