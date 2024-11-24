package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "articulos_del_blog")
public class ArticuloDelBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Lob
    private String contenido;

    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @ManyToOne
    private Usuario autor;

    private String categoria;

    @Lob
    private String etiquetas;
}