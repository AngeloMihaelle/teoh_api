package com.teoh.api.controller;

import com.teoh.api.model.Caso;
import com.teoh.api.service.CasoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casos")
public class CasoController {

    private final CasoService casoService;

    public CasoController(CasoService casoService) {
        this.casoService = casoService;
    }

    @GetMapping
    public List<Caso> getAllCasos() {
        return casoService.findAll();
    }

    @GetMapping("/{id}")
    public Caso getCasoById(@PathVariable Integer id) {
        return casoService.findById(id);
    }

    @PostMapping
    public Caso createCaso(@RequestBody Caso caso) {
        return casoService.save(caso);
    }

    @PutMapping("/{id}")
    public Caso updateCaso(@PathVariable Integer id, @RequestBody Caso caso) {
        caso.setId(id);
        return casoService.save(caso);
    }

    @DeleteMapping("/{id}")
    public void deleteCaso(@PathVariable Integer id) {
        casoService.deleteById(id);
    }
}
