package com.wjd.hotel.resources;

import com.wjd.hotel.dtos.QuartoEntradaDto;
import com.wjd.hotel.dtos.QuartoSaidaDto;
import com.wjd.hotel.services.QuartoService;
import com.wjd.hotel.services.impl.QuartoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartos")
public class QuartoResource {
    private final QuartoService quartoService;

    public QuartoResource(QuartoServiceImpl quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping
    public ResponseEntity<QuartoSaidaDto> salvarQuarto(@RequestBody QuartoEntradaDto quartoEntradaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.salvarQuarto(quartoEntradaDto));
    }
}
