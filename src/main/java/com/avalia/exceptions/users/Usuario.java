package com.avalia.exceptions.users;

import com.avalia.exceptions.pedidos.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS", uniqueConstraints =
        {@UniqueConstraint(name = "UK_USERNAME", columnNames = "username"),
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "email")})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome is required")
    @Size(min = 3, max = 100, message = "Nome must be between 3 and 100 characters")
    @Column(name = "username", nullable = false, length = 100)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Nome can only contain letters, numbers, and underscores")
    private String nome;

    @NotBlank(message = "email is required")
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8, message = "password must be at least 8 characters long")
    @Column(name = "password", nullable = false)
    private String senha;

    @Column(name = "first_name", length = 50)
    private String primeiroNome;

    @Column(name = "last_name", length = 50)
    private String ultimoNome;

    @Column(name = "active", nullable = false)
    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private StatusUsuario status = StatusUsuario.ACTIVE;

    @Column(name = "role_id")
    private Long permissaoUsuario;

    @Column(name = "version")
    private Long versao;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @Column(name = "deleted_at")
    private LocalDateTime dataExclusao;

    @Column(name = "last_login_at")
    private LocalDateTime ultimoLogin;

    private List<Pedido> pedidos = new ArrayList<>();
}
