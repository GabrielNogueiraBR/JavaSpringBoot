package com.example.aula_29_10_2020_spring_boot.model;

import java.util.ArrayList;

public class Cliente {
    private int codigo;
    private String nome;
    private String endereço;
    private double saldo;

    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    
}
