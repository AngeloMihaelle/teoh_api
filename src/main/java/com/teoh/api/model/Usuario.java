package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Table(name = "usuarios")
@Schema(description = "Modelo que representa a un usuario en TEOH, incluyendo tanto a clientes como a administradores")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del usuario", example = "1")
    private Integer id;

    @Schema(description = "Nombre completo del usuario", example = "Juan Pérez")
    private String nombre;

    @Column(unique = true, nullable = false)
    @Schema(description = "Correo electrónico único del usuario", example = "juan.perez@teoh.com")
    private String correoElectronico;

    @Schema(description = "Contraseña del usuario (encriptada)", example = "********")
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Rol del usuario en el sistema", example = "CLIENTE")
    private Rol rol = Rol.CLIENTE;

    @Lob
    @Schema(description = "Historial de compras del usuario", example = "Compra 1: Producto A, Compra 2: Producto B")
    private String historialCompras;

    @Lob
    @Schema(description = "Preferencias del usuario", example = "Preferencia 1: Entregas por la mañana, Preferencia 2: Descuento en productos para el cuidado de heridas")
    private String preferencias;

    public enum Rol {
        CLIENTE, ADMIN
    }
}
