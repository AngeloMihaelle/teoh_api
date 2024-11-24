package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Table(name = "productos")
@Schema(description = "Modelo que representa un producto disponible para compra en TEOH")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del producto", example = "1")
    private Integer id;

    @Schema(description = "Nombre del producto", example = "Venda para heridas")
    private String nombre;

    @Lob
    @Schema(description = "Descripción detallada del producto", example = "Esta venda es ideal para el tratamiento de heridas menores...")
    private String descripcion;

    @Schema(description = "Categoría del producto", example = "Suministros médicos")
    private String categoria;

    @Schema(description = "Precio del producto", example = "29.99")
    private Double precio;

    @Schema(description = "Cantidad de stock disponible", example = "150")
    private Integer stock;

    @Schema(description = "Imagen del producto", example = "base64_encoded_image_data_here")
    private String imagen;

    @Schema(description = "Valoración promedio del producto por los usuarios", example = "4.5")
    private Float valoracion;
}
