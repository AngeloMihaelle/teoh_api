package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(unique = true, nullable = false)
    private String correoElectronico;

    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.CLIENTE;

    @Lob
    private String historialCompras;

    @Lob
    private String preferencias;

    public enum Rol {
        CLIENTE, ADMIN
    }
}
