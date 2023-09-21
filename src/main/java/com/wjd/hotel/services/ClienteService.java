package com.wjd.hotel.services;

import com.wjd.hotel.dtos.ClienteEntradaDto;
import com.wjd.hotel.dtos.ClienteSaidaDto;

public interface ClienteService {

    public ClienteSaidaDto salvarCliente (ClienteEntradaDto clienteEntradaDto);
}
