package com.wjd.hotel.services.impl;

import com.wjd.hotel.dtos.UsuarioEntradaDto;
import com.wjd.hotel.dtos.UsuarioSaidaDto;
import com.wjd.hotel.exceptions.impl.DataIntegrityViolationExceptionApp;
import com.wjd.hotel.exceptions.impl.ObjectNotFoundExceptionApp;
import com.wjd.hotel.mappers.UsuarioMapper;
import com.wjd.hotel.repository.UsuarioRepository;
import com.wjd.hotel.services.UsuarioService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(final UsuarioRepository usuarioRepository, final UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioSaidaDto salvarUsuario(UsuarioEntradaDto usuarioEntradaDto) {
        try {
            return usuarioMapper.deUsuarioEntidadeParaUsuarioSaidaDto(usuarioRepository.save(usuarioMapper.deUsuarioEntradaDtoParaUsuarioEntidade(usuarioEntradaDto)));
        } catch (DataIntegrityViolationException err) {
            throw new DataIntegrityViolationExceptionApp("Conflito na base de dados");
        }
    }

    @Override
    public UsuarioSaidaDto buscarUsuarioPorId(Long id) {
        return usuarioMapper.deUsuarioEntidadeParaUsuarioSaidaDto(usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExceptionApp(("Usuario não encontrado com o ID: " + id))));
    }
}
