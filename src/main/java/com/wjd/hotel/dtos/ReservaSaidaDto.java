package com.wjd.hotel.dtos;

import com.wjd.hotel.domain.Cliente;
import com.wjd.hotel.domain.Quarto;
import com.wjd.hotel.domain.Usuario;

import java.time.LocalDate;

public class ReservaSaidaDto {
    private Long id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private QuartoSaidaDto quarto;
    private ClienteSaidaDto cliente;

    public ReservaSaidaDto() {
    }

    public ReservaSaidaDto(Long id, LocalDate checkIn, LocalDate checkOut, QuartoSaidaDto quarto, ClienteSaidaDto cliente) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quarto = quarto;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public QuartoSaidaDto getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoSaidaDto quarto) {
        this.quarto = quarto;
    }

    public ClienteSaidaDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSaidaDto cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ReservaSaidaDto{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", quarto=" + quarto +
                ", cliente=" + cliente +
                '}';
    }
}
