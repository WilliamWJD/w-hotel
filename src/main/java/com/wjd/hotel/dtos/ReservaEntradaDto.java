package com.wjd.hotel.dtos;

public class ReservaEntradaDto {
    private Long id;
    private String checkIn;
    private String checkOut;
    private Integer diarias;
    private Long usuarioId;
    private Long quartoId;
    private Long clienteId;

    public ReservaEntradaDto() {
    }

    public ReservaEntradaDto(Long id, String checkIn, String checkOut, Integer diarias, Long usuarioId, Long quartoId, Long clienteId) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.diarias = diarias;
        this.usuarioId = usuarioId;
        this.quartoId = quartoId;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getDiarias() {
        return diarias;
    }

    public void setDiarias(Integer diarias) {
        this.diarias = diarias;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Long quartoId) {
        this.quartoId = quartoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "ReservaEntradaDto{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", diarias=" + diarias +
                ", usuarioId=" + usuarioId +
                ", quartoId=" + quartoId +
                ", clienteId=" + clienteId +
                '}';
    }
}
