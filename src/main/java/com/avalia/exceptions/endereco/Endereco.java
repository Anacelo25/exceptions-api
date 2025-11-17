package com.avalia.exceptions.endereco;


import jakarta.persistence.*;

@Entity
@Table(name = "TAB_ADDRESSES")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String rua;

    @Column(name = "city")
    private String cidade;

    @Column(name = "state")
    private String estado;

    @Column(name = "zip_code")
    private String cep;

    @Column(name = "country")
    private String pais;
}
