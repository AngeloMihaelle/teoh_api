package com.teoh.api.controller;

import com.teoh.api.model.Caso;
import com.teoh.api.service.CasoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casos")
@Tag(name = "Casos", description = "Operaciones relacionadas con casos de éxito y testimonios")
@CrossOrigin(origins = "*")
public class CasoController {

    private final CasoService casoService;

    public CasoController(CasoService casoService) {
        this.casoService = casoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los casos", 
               description = "Devuelve una lista de todos los casos de éxito y testimonios almacenados.")
    public List<Caso> getAllCasos() {
        return casoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un caso por ID", 
               description = "Devuelve los detalles de un caso específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del caso", required = true))
    public Caso getCasoById(@PathVariable Integer id) {
        return casoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo caso", 
               description = "Permite agregar un nuevo caso de éxito o testimonio proporcionando los detalles en el cuerpo de la solicitud.")
    public Caso createCaso(@RequestBody Caso caso) {
        return casoService.save(caso);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un caso existente", 
               description = "Actualiza los detalles de un caso específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del caso", required = true))
    public Caso updateCaso(@PathVariable Integer id, @RequestBody Caso caso) {
        caso.setId(id);
        return casoService.save(caso);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un caso", 
               description = "Elimina un caso de éxito o testimonio identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del caso", required = true))
    public void deleteCaso(@PathVariable Integer id) {
        casoService.deleteById(id);
    }
}
