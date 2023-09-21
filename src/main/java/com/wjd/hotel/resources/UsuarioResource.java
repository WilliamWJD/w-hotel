package com.wjd.hotel.resources;

import com.wjd.hotel.dtos.UsuarioEntradaDto;
import com.wjd.hotel.dtos.UsuarioSaidaDto;
import com.wjd.hotel.services.UsuarioService;
import com.wjd.hotel.services.impl.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioServiceImpl usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioSaidaDto> salvarUsuario(@RequestBody UsuarioEntradaDto usuarioEntradaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuarioEntradaDto));
    }
}
