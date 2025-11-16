package com.avalia.exceptions.pedidos;

import jakarta.persistence.*;

@Entity
@Table(name = "TAB_ORDER")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
