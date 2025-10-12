package com.avalia.exceptions.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "USERS", uniqueConstraints =
        {@UniqueConstraint(name = "UK_USERNAME", columnNames = "username"),
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "email")})
public class User {

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
    private boolean ativo = true;
}
