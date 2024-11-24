package com.teoh.api.controller;

import com.teoh.api.model.ArticuloDelBlog;
import com.teoh.api.service.ArticuloDelBlogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloDelBlogController {

    private final ArticuloDelBlogService articuloDelBlogService;

    public ArticuloDelBlogController(ArticuloDelBlogService articuloDelBlogService) {
        this.articuloDelBlogService = articuloDelBlogService;
    }

    @GetMapping
    public List<ArticuloDelBlog> getAllArticulos() {
        return articuloDelBlogService.findAll();
    }

    @GetMapping("/{id}")
    public ArticuloDelBlog getArticuloById(@PathVariable Integer id) {
        return articuloDelBlogService.findById(id);
    }

    @PostMapping
    public ArticuloDelBlog createArticulo(@RequestBody ArticuloDelBlog articulo) {
        return articuloDelBlogService.save(articulo);
    }

    @PutMapping("/{id}")
    public ArticuloDelBlog updateArticulo(@PathVariable Integer id, @RequestBody ArticuloDelBlog articulo) {
        articulo.setId(id);
        return articuloDelBlogService.save(articulo);
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable Integer id) {
        articuloDelBlogService.deleteById(id);
    }
}