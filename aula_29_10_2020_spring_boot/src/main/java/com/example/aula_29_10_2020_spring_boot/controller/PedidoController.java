package com.example.aula_29_10_2020_spring_boot.controller;

import java.util.List;

import com.example.aula_29_10_2020_spring_boot.model.Pedido;
import com.example.aula_29_10_2020_spring_boot.service.ClienteService;
import com.example.aula_29_10_2020_spring_boot.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping()
    public List<Pedido> getAllPedidos() {
        return service.getAllPedidos();
    }

    @GetMapping("/{codigo}")
    public Pedido getPedidoByCodigo(@PathVariable int codigo) {
        Pedido = service.getPedidoByNumero(codigo);

    }

}
