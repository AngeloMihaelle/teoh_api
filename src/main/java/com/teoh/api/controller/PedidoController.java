package com.teoh.api.controller;

import com.teoh.api.model.Pedido;
import com.teoh.api.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Operaciones relacionadas con la gestión de pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los pedidos", 
               description = "Devuelve una lista de todos los pedidos realizados.")
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un pedido por ID", 
               description = "Devuelve los detalles de un pedido específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del pedido", required = true))
    public Pedido getPedidoById(@PathVariable Integer id) {
        return pedidoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo pedido", 
               description = "Permite crear un nuevo pedido proporcionando los detalles necesarios en el cuerpo de la solicitud.")
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un pedido existente", 
               description = "Actualiza la información de un pedido específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del pedido", required = true))
    public Pedido updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoService.save(pedido);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un pedido", 
               description = "Elimina un pedido específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del pedido", required = true))
    public void deletePedido(@PathVariable Integer id) {
        pedidoService.deleteById(id);
    }
}
