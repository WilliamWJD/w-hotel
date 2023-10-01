package com.wjd.hotel.services;

import com.wjd.hotel.dtos.ReservaEntradaDto;
import com.wjd.hotel.dtos.ReservaSaidaDto;

public interface ReservaService {

    public ReservaSaidaDto salvarReserva(ReservaEntradaDto reservaEntradaDto);
    public ReservaSaidaDto atualizarReserva(final Long reservaId, ReservaEntradaDto reservaEntradaDto);
}
