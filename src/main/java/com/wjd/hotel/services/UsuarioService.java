package com.wjd.hotel.services;

import com.wjd.hotel.dtos.UsuarioEntradaDto;
import com.wjd.hotel.dtos.UsuarioSaidaDto;

public interface UsuarioService {

    public UsuarioSaidaDto salvarUsuario(UsuarioEntradaDto usuarioEntradaDto);
    public UsuarioSaidaDto buscarUsuarioPorId(final Long id);
}
