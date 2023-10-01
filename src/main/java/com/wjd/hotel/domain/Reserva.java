package com.wjd.hotel.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer diarias;
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "quarto_id", nullable = false)
    private Quarto quarto;

    public Reserva() {
    }

    public Reserva(Long id, LocalDate checkIn, LocalDate checkOut, Integer diarias, LocalDateTime dataCriacao, Usuario usuario, Cliente cliente, Quarto quarto) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.diarias = diarias;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.cliente = cliente;
        this.quarto = quarto;
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

    public Integer getDiarias() {
        return diarias;
    }

    public void setDiarias(Integer diarias) {
        this.diarias = diarias;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", diarias=" + diarias +
                ", dataCriacao=" + dataCriacao +
                ", usuario=" + usuario +
                ", cliente=" + cliente +
                ", quarto=" + quarto +
                '}';
    }
}
