package com.wjd.hotel.services.impl;

import com.wjd.hotel.domain.Reserva;
import com.wjd.hotel.dtos.*;
import com.wjd.hotel.exceptions.impl.HotelExceptionApp;
import com.wjd.hotel.exceptions.impl.ObjectNotFoundExceptionApp;
import com.wjd.hotel.mappers.ReservaMapper;
import com.wjd.hotel.repository.ReservaRepository;
import com.wjd.hotel.services.ClienteService;
import com.wjd.hotel.services.QuartoService;
import com.wjd.hotel.services.ReservaService;
import com.wjd.hotel.services.UsuarioService;
import com.wjd.hotel.utils.DateParse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final ClienteService clienteService;
    private final QuartoService quartoService;
    private final UsuarioService usuarioService;
    private final ReservaMapper reservaMapper;

    public ReservaServiceImpl(ReservaRepository reservaRepository, ClienteService clienteService, QuartoService quartoService, UsuarioService usuarioService, ReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.clienteService = clienteService;
        this.quartoService = quartoService;
        this.usuarioService = usuarioService;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public ReservaSaidaDto salvarReserva(ReservaEntradaDto reservaEntradaDto) {
        // recupera dados do cliente
        ClienteSaidaDto cliente = clienteService.buscarClientePorId(reservaEntradaDto.getClienteId());

        // recupera dados do quarto
        QuartoSaidaDto quarto = quartoService.buscarQuartoPorId(reservaEntradaDto.getQuartoId());

        // recupera usuario
        UsuarioSaidaDto usuario = usuarioService.buscarUsuarioPorId(reservaEntradaDto.getUsuarioId());

        // verifica quantidade de diarias
        long diarias = ChronoUnit.DAYS.between(DateParse.paraLocalDate(reservaEntradaDto.getCheckIn()), DateParse.paraLocalDate(reservaEntradaDto.getCheckOut()));

        // validação de datas
        validaDataDeCheckInECheckOut(reservaEntradaDto);

        // verfica disponibilidade do quarto
        verificaDisponibilidadeDeQuarto(reservaEntradaDto.getQuartoId(), DateParse.paraLocalDate(reservaEntradaDto.getCheckIn()), reservaEntradaDto.getId());

        Reserva reserva = reservaMapper.deReservaEntradaDtoParaReservaEntidade(reservaEntradaDto, usuario, cliente, quarto, diarias);

        // ajusta data de checkout caso data de checkIn seja igual a data de checkOut
        if(reserva.getCheckOut().isEqual(reserva.getCheckIn())){
            reserva.setCheckOut(reserva.getCheckIn().plusDays(1));
        }

        return reservaMapper.deReservaEntidadeParaReservaSaidaDto(reservaRepository.save(reserva));
    }

    @Override
    public ReservaSaidaDto atualizarReserva(Long reservaId, ReservaEntradaDto reservaEntradaDto) {
        reservaRepository.findById(reservaId).orElseThrow(()-> new ObjectNotFoundExceptionApp("Reserva não encontrada!"));

        return salvarReserva(reservaEntradaDto);
    }

    @Override
    public ReservaSaidaDto buscarReservaPorId(Long reservaId) {
        return reservaMapper.deReservaEntidadeParaReservaSaidaDto(reservaRepository.findById(reservaId).orElseThrow(()-> new ObjectNotFoundExceptionApp("Reserva não encontrada!")));
    }

    @Override
    public void excluirReserva(Long reservaId) {
        buscarReservaPorId(reservaId);
        reservaRepository.deleteById(reservaId);
    }

    private void validaDataDeCheckInECheckOut(ReservaEntradaDto reservaEntradaDto) {
        // não permite realizar checkIn com datas anteriores a data hoje
        if(DateParse.paraLocalDate(reservaEntradaDto.getCheckIn()).isBefore(LocalDate.now())){
            throw new HotelExceptionApp("Não é possível fazer uma reserva com datas anteriores a data atual");
        }

        // não permite realizar checkIn com data de checkOut menor que a data de checkIn
        if(DateParse.paraLocalDate(reservaEntradaDto.getCheckOut()).isBefore(DateParse.paraLocalDate(reservaEntradaDto.getCheckIn()))){
            throw new HotelExceptionApp("Não é possivel fazer uma reserva com data de checkout menor que a data de checkIn");
        }
    }

    private Boolean verificaDisponibilidadeDeQuarto(final Long quartoId, final LocalDate checkIn, final Long reservaId) {
        Optional<Reserva> reserva;

        if(Objects.nonNull(reservaId)){
            reserva = reservaRepository.verificarDisponibilidadeDeQuarto(quartoId, checkIn, reservaId);
        }else{
            reserva =  reservaRepository.verificarDisponibilidadeDeQuarto(quartoId, checkIn);
        }

        if (reserva.isPresent()) {
            throw new HotelExceptionApp("Quarto com id: " + quartoId + " andar " + reserva.get().getQuarto().getAndar() + " indisponível");
        }
        return true;
    }
}
