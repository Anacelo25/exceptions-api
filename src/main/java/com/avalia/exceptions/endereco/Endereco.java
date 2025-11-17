package com.avalia.exceptions.endereco;


import jakarta.persistence.*;

@Entity
@Table(name = "TAB_ADDRESSES")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
