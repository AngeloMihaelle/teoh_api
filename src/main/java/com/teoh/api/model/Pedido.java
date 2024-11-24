package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;

@Data
@Entity
@Table(name = "pedidos")
@Schema(description = "Modelo que representa un pedido realizado por un usuario en TEOH")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del pedido", example = "1")
    private Integer id;

    @ManyToOne
    @Schema(description = "Usuario que realiza el pedido", implementation = Usuario.class)
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    @Schema(description = "Fecha en que se realizó el pedido", example = "2024-11-24")
    private Date fechaPedido;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Estado actual del pedido", example = "EN_PROCESO")
    private EstadoPedido estadoPedido = EstadoPedido.EN_PROCESO;

    @Schema(description = "Total del pedido en valor monetario", example = "150.75")
    private Double totalPedido;

    @Lob
    @Schema(description = "Detalles adicionales de envío, como dirección, instrucciones especiales", example = "Dirección: Calle Ficticia 123, Instrucciones: Entregar por la tarde.")
    private String detallesEnvio;

    public enum EstadoPedido {
        EN_PROCESO, ENVIADO, ENTREGADO
    }
}
