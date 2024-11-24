package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Lob
    private String descripcion;

    private String categoria;

    private Double precio;

    private Integer stock;

    private String imagen;

    private Float valoracion;
}
