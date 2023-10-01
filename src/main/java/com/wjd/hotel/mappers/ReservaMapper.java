package com.wjd.hotel.mappers;

import com.wjd.hotel.domain.Reserva;
import com.wjd.hotel.dtos.*;
import com.wjd.hotel.utils.DateParse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservaMapper {
    private ClienteMapper clienteMapper;
    private UsuarioMapper usuarioMapper;
    private QuartoMapper quartoMapper;

    public ReservaMapper(ClienteMapper clienteMapper, UsuarioMapper usuarioMapper, QuartoMapper quartoMapper) {
        this.clienteMapper = clienteMapper;
        this.usuarioMapper = usuarioMapper;
        this.quartoMapper = quartoMapper;
    }

    public Reserva deReservaEntradaDtoParaReservaEntidade(ReservaEntradaDto reservaEntradaDto, UsuarioSaidaDto usuario, ClienteSaidaDto cliente, QuartoSaidaDto quarto, long diarias) {
        Reserva reserva = new Reserva();

        reserva.setCheckIn(DateParse.paraLocalDate(reservaEntradaDto.getCheckIn()));
        reserva.setCheckOut(DateParse.paraLocalDate(reservaEntradaDto.getCheckOut()));
        reserva.setDiarias((int) diarias);
        reserva.setCliente(clienteMapper.deClienteSaidaDtoParaClienteEntidade(cliente));
        reserva.setUsuario(usuarioMapper.deUsuarioSaidaDtoParaUsuarioEntidade(usuario));
        reserva.setQuarto(quartoMapper.deQuartoSaidaDtoParaQuartoEntidade(quarto));
        reserva.setDataCriacao(LocalDateTime.now());

        return reserva;
    }

    public ReservaSaidaDto deReservaEntidadeParaReservaSaidaDto(Reserva reserva){
        ReservaSaidaDto reservaSaidaDto = new ReservaSaidaDto();

        reservaSaidaDto.setId(reserva.getId());
        reservaSaidaDto.setCheckIn(reserva.getCheckIn());
        reservaSaidaDto.setCheckOut(reserva.getCheckOut());
        reservaSaidaDto.setCliente(clienteMapper.deClienteEntidadeParaClienteSaidaDto(reserva.getCliente()));
        reservaSaidaDto.setQuarto(quartoMapper.deQuartoEntidadeParaQuartoSaidaDto(reserva.getQuarto()));

        return reservaSaidaDto;
    }
}
