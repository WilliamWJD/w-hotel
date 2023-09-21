package com.wjd.hotel.dtos;

public class QuartoSaidaDto {
    private Long id;
    private Integer num;
    private Integer andar;

    public QuartoSaidaDto() {
    }

    public QuartoSaidaDto(Long id, Integer num, Integer andar) {
        this.id = id;
        this.num = num;
        this.andar = andar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }


    @Override
    public String toString() {
        return "QuartoSaidaDto{" +
                "id=" + id +
                ", num=" + num +
                ", andar=" + andar +
                '}';
    }
}
