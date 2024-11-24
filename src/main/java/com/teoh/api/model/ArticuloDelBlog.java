package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;

@Data
@Entity
@Table(name = "articulos_del_blog")
@Schema(description = "Modelo que representa los artículos del blog del sitio TEOH")
public class ArticuloDelBlog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del artículo del blog", example = "1")
    private Integer id;

    @Schema(description = "Título del artículo", example = "Tratamiento de heridas de ostomía")
    private String titulo;

    @Lob
    @Schema(description = "Contenido completo del artículo", example = "El artículo describe el proceso de cuidado de las heridas...")
    private String contenido;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Fecha de publicación del artículo", example = "2024-11-24")
    private Date fechaPublicacion;

    @ManyToOne
    @Schema(description = "Autor del artículo del blog", implementation = Usuario.class)
    private Usuario autor;

    @Schema(description = "Categoría a la que pertenece el artículo", example = "Salud")
    private String categoria;

    @Lob
    @Schema(description = "Etiquetas relacionadas con el artículo", example = "cuidado, ostomía, heridas")
    private String etiquetas;
}
