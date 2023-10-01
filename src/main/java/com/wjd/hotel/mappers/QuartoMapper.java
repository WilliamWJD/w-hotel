package com.wjd.hotel.mappers;

import com.wjd.hotel.domain.Quarto;
import com.wjd.hotel.dtos.QuartoEntradaDto;
import com.wjd.hotel.dtos.QuartoSaidaDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class QuartoMapper {

    public Quarto deQuartoEntradaDtoParaQuartoEntidade(QuartoEntradaDto quartoEntradaDto) {
        Quarto quarto = new Quarto();

        if (Objects.nonNull(quartoEntradaDto.getId())) {
            quarto.setId(quartoEntradaDto.getId());
        }

        quarto.setAndar(quartoEntradaDto.getAndar());
        quarto.setnumQuarto(quartoEntradaDto.getNum());
        quarto.setValor(quartoEntradaDto.getValor());

        return quarto;
    }

    public QuartoSaidaDto deQuartoEntidadeParaQuartoSaidaDto(Quarto quarto){
        QuartoSaidaDto quartoSaidaDto = new QuartoSaidaDto();

        quartoSaidaDto.setId(quarto.getId());
        quartoSaidaDto.setNum(quarto.getnumQuarto());
        quartoSaidaDto.setAndar(quarto.getAndar());

        return quartoSaidaDto;
    }

    public Quarto deQuartoSaidaDtoParaQuartoEntidade(QuartoSaidaDto quartoSaidaDto){
        return new Quarto(quartoSaidaDto.getId(), quartoSaidaDto.getNum(), quartoSaidaDto.getAndar(), null);
    }
}
