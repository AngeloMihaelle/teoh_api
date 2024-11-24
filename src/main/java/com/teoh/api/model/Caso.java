package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;

@Data
@Entity
@Schema(description = "Modelo que representa los casos de éxito en el sitio TEOH")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del caso", example = "1")
    private Integer id;

    @Schema(description = "Título del caso", example = "Recuperación exitosa de una herida severa")
    private String titulo;

    @Lob
    @Schema(description = "Descripción detallada del caso", example = "Este caso muestra el tratamiento exitoso de una herida severa...")
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Fecha en la que se documentó el caso", example = "2024-11-24")
    private Date fecha;

    @Lob
    @Schema(description = "Imágenes relacionadas con el caso, pueden ser múltiples", example = "base64_encoded_image_data_here")
    private String imagenes;

    @Lob
    @Schema(description = "Testimonio del paciente o persona involucrada en el caso", example = "Gracias al tratamiento de TEOH, pude recuperar completamente mi bienestar...")
    private String testimonio;

    @ManyToOne
    @Schema(description = "Usuario asociado con el caso (paciente o cuidador)", implementation = Usuario.class)
    private Usuario usuario;
}
