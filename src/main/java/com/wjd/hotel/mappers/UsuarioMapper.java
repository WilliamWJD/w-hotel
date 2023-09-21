package com.wjd.hotel.mappers;

import com.wjd.hotel.domain.Usuario;
import com.wjd.hotel.dtos.UsuarioEntradaDto;
import com.wjd.hotel.dtos.UsuarioSaidaDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UsuarioMapper {
    public Usuario deUsuarioEntradaDtoParaUsuarioEntidade(UsuarioEntradaDto usuarioEntradaDto) {
        Usuario usuario = new Usuario();

        if (Objects.nonNull(usuarioEntradaDto.getId())) {
            usuario.setId(usuarioEntradaDto.getId());
        }

        usuario.setNome(usuarioEntradaDto.getNome());
        usuario.setCpf(usuarioEntradaDto.getCpf());
        usuario.setEmail(usuarioEntradaDto.getEmail());
        return usuario;
    }

    public UsuarioSaidaDto deUsuarioEntidadeParaUsuarioSaidaDto(Usuario usuario) {
        UsuarioSaidaDto usuarioSaidaDto = new UsuarioSaidaDto();

        usuarioSaidaDto.setId(usuario.getId());
        usuarioSaidaDto.setNome(usuario.getNome());
        usuarioSaidaDto.setEmail(usuario.getEmail());

        return usuarioSaidaDto;
    }
}
