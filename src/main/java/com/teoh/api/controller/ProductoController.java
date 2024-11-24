package com.teoh.api.controller;

import com.teoh.api.model.Producto;
import com.teoh.api.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con la gestión de productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", 
               description = "Devuelve una lista de todos los productos disponibles en la tienda.")
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID", 
               description = "Devuelve los detalles de un producto específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del producto", required = true))
    public Producto getProductoById(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", 
               description = "Permite crear un nuevo producto proporcionando los detalles en el cuerpo de la solicitud.")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente", 
               description = "Actualiza los detalles de un producto identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del producto", required = true))
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", 
               description = "Elimina un producto identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del producto", required = true))
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteById(id);
    }
}
