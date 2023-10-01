package com.wjd.hotel.services;

import com.wjd.hotel.dtos.QuartoEntradaDto;
import com.wjd.hotel.dtos.QuartoSaidaDto;

import java.time.LocalDate;

public interface QuartoService {

    public QuartoSaidaDto salvarQuarto(QuartoEntradaDto quartoEntradaDto);

    public QuartoSaidaDto buscarQuartoPorId(final Long id);
}
