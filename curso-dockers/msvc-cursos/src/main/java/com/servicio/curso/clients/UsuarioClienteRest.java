package com.servicio.curso.clients;

import com.servicio.curso.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msvc-usuarios", url = "msvc-usuario:6666/usuario")
public interface UsuarioClienteRest {

    @GetMapping("/obtener/{id}")
    Usuario detalle(@PathVariable Long id);

    @PostMapping("/crear")
    Usuario crear(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario>obtenerUsuarioPorCurso (@RequestParam Iterable<Long> ids);
}
