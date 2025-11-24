package com.avalia.exceptions.endereco;


import com.avalia.exceptions.usuario.Usuario;
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

    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType tipoEndereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Usuario usuario;
}
