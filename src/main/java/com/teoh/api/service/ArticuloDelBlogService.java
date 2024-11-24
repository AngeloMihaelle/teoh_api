package com.teoh.api.service;

import com.teoh.api.model.ArticuloDelBlog;
import com.teoh.api.repository.ArticuloDelBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloDelBlogService {

    private final ArticuloDelBlogRepository articuloDelBlogRepository;

    public ArticuloDelBlogService(ArticuloDelBlogRepository articuloDelBlogRepository) {
        this.articuloDelBlogRepository = articuloDelBlogRepository;
    }

    public List<ArticuloDelBlog> findAll() {
        return articuloDelBlogRepository.findAll();
    }

    public ArticuloDelBlog findById(Integer id) {
        return articuloDelBlogRepository.findById(id).orElse(null);
    }

    public ArticuloDelBlog save(ArticuloDelBlog articulo) {
        return articuloDelBlogRepository.save(articulo);
    }

    public void deleteById(Integer id) {
        articuloDelBlogRepository.deleteById(id);
    }
}