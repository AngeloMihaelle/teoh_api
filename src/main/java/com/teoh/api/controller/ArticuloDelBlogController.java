package com.teoh.api.controller;

import com.teoh.api.model.ArticuloDelBlog;
import com.teoh.api.service.ArticuloDelBlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@Tag(name = "Artículos del Blog", description = "Operaciones relacionadas con los artículos del blog")
@CrossOrigin(origins = "*")
public class ArticuloDelBlogController {

    private final ArticuloDelBlogService articuloDelBlogService;

    public ArticuloDelBlogController(ArticuloDelBlogService articuloDelBlogService) {
        this.articuloDelBlogService = articuloDelBlogService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los artículos",
               description = "Devuelve una lista de todos los artículos del blog disponibles.")
    public List<ArticuloDelBlog> getAllArticulos() {
        return articuloDelBlogService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un artículo por ID",
               description = "Devuelve un artículo específico del blog identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del artículo", required = true))
    public ArticuloDelBlog getArticuloById(@PathVariable Integer id) {
        return articuloDelBlogService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo artículo",
               description = "Crea un nuevo artículo del blog con la información proporcionada en el cuerpo de la solicitud.")
    public ArticuloDelBlog createArticulo(@RequestBody ArticuloDelBlog articulo) {
        return articuloDelBlogService.save(articulo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un artículo existente",
               description = "Actualiza un artículo del blog existente identificado por su ID con los nuevos datos proporcionados.",
               parameters = @Parameter(name = "id", description = "ID del artículo", required = true))
    public ArticuloDelBlog updateArticulo(@PathVariable Integer id, @RequestBody ArticuloDelBlog articulo) {
        articulo.setId(id);
        return articuloDelBlogService.save(articulo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un artículo",
               description = "Elimina un artículo del blog identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del artículo", required = true))
    public void deleteArticulo(@PathVariable Integer id) {
        articuloDelBlogService.deleteById(id);
    }
}
