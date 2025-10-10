package com.avalia.exceptions.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome is required")
    @Size(min = 3, max = 100, message = "Nome must be between 3 and 100 characters")
    @Column(name = "username", nullable = false, length = 100)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Nome can only contain letters, numbers, and underscores")
    private String nome;
}
