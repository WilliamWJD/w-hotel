package com.wjd.hotel.services;

import com.wjd.hotel.dtos.ReservaEntradaDto;
import com.wjd.hotel.dtos.ReservaSaidaDto;

public interface ReservaService {

    public ReservaSaidaDto salvarReserva(ReservaEntradaDto reservaEntradaDto);
}
