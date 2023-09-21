package com.wjd.hotel.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "quartos")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer num;
    private Integer andar;
    private BigDecimal valor;

    public Quarto() {
    }

    public Quarto(Long id, Integer num, Integer andar, BigDecimal valor) {
        this.id = id;
        this.num = num;
        this.andar = andar;
        this.valor = valor;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "id=" + id +
                ", num=" + num +
                ", andar=" + andar +
                ", valor=" + valor +
                '}';
    }
}
