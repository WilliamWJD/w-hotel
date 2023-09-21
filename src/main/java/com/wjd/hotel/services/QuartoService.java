package com.wjd.hotel.services;

import com.wjd.hotel.dtos.QuartoEntradaDto;
import com.wjd.hotel.dtos.QuartoSaidaDto;

public interface QuartoService {

    public QuartoSaidaDto salvarQuarto(QuartoEntradaDto quartoEntradaDto);
}
