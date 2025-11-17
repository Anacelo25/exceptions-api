package com.avalia.exceptions.pedidos;

import com.avalia.exceptions.users.Usuario;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TAB_ORDER")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", unique = true)
    private String numero;

    @Column(name = "details", length = 1000)
    private String detalhes;

    @Column(name = "total_amount")
    private BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status = StatusPedido.PENDING;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Usuario usuario;
}
