package com.wjd.hotel.services.impl;

import com.wjd.hotel.dtos.QuartoEntradaDto;
import com.wjd.hotel.dtos.QuartoSaidaDto;
import com.wjd.hotel.exceptions.impl.DataIntegrityViolationExceptionApp;
import com.wjd.hotel.exceptions.impl.ObjectNotFoundExceptionApp;
import com.wjd.hotel.mappers.QuartoMapper;
import com.wjd.hotel.repository.QuartoRepository;
import com.wjd.hotel.services.QuartoService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class QuartoServiceImpl implements QuartoService {

    private final QuartoRepository quartoRepository;
    private final QuartoMapper quartoMapper;

    public QuartoServiceImpl(QuartoRepository quartoRepository, QuartoMapper quartoMapper) {
        this.quartoRepository = quartoRepository;
        this.quartoMapper = quartoMapper;
    }

    @Override
    public QuartoSaidaDto salvarQuarto(QuartoEntradaDto quartoEntradaDto) {
        try {
            return quartoMapper.deQuartoEntidadeParaQuartoSaidaDto(quartoRepository.save(quartoMapper.deQuartoEntradaDtoParaQuartoEntidade(quartoEntradaDto)));
        } catch (DataIntegrityViolationException err) {
            throw new DataIntegrityViolationExceptionApp("Conflito na base de dados");
        }
    }

    @Override
    public QuartoSaidaDto buscarQuartoPorId(Long id) {
        return quartoMapper.deQuartoEntidadeParaQuartoSaidaDto(quartoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExceptionApp("Quarto não encontrado com o ID: " + id)));
    }
}
