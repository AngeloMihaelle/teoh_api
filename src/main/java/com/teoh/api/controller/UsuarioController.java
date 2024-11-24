package com.teoh.api.controller;

import com.teoh.api.model.Usuario;
import com.teoh.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con la gestión de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", 
               description = "Devuelve una lista de todos los usuarios registrados en el sistema.")
    public List<Usuario> getAllUsuarios() {
        System.out.println("Fetching all usuarios...");
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", 
               description = "Devuelve los detalles de un usuario específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del usuario", required = true))
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario", 
               description = "Permite crear un nuevo usuario proporcionando los datos en el cuerpo de la solicitud.")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario existente", 
               description = "Actualiza la información de un usuario identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del usuario", required = true))
    public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", 
               description = "Elimina un usuario específico identificado por su ID.",
               parameters = @Parameter(name = "id", description = "ID del usuario", required = true))
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteById(id);
    }
}
