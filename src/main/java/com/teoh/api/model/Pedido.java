package com.teoh.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido = EstadoPedido.EN_PROCESO;

    private Double totalPedido;

    @Lob
    private String detallesEnvio;

    public enum EstadoPedido {
        EN_PROCESO, ENVIADO, ENTREGADO
    }
}
