package com.example.aula_29_10_2020_spring_boot.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.aula_29_10_2020_spring_boot.model.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private int nextCode;
}
