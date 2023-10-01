package com.wjd.hotel.resources;

import com.wjd.hotel.dtos.ReservaEntradaDto;
import com.wjd.hotel.dtos.ReservaSaidaDto;
import com.wjd.hotel.services.ReservaService;
import com.wjd.hotel.services.impl.ReservaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaResource {
    private final ReservaService reservaService;

    public ReservaResource(ReservaServiceImpl reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaSaidaDto> salvarReserva(@RequestBody ReservaEntradaDto reservaEntradaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvarReserva(reservaEntradaDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReservaSaidaDto> atualizarReserva(@RequestBody ReservaEntradaDto reservaEntradaDto, @PathVariable(name = "id") final Long reservaId){
        reservaEntradaDto.setId(reservaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.atualizarReserva(reservaId, reservaEntradaDto));
    }
}
