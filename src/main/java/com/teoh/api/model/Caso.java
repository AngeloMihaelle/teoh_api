package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Lob
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Lob
    private String imagenes;

    @Lob
    private String testimonio;

    @ManyToOne
    private Usuario usuario;
}
