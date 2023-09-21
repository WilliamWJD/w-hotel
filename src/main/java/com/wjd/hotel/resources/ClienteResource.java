package com.wjd.hotel.resources;

import com.wjd.hotel.dtos.ClienteEntradaDto;
import com.wjd.hotel.dtos.ClienteSaidaDto;
import com.wjd.hotel.services.ClienteService;
import com.wjd.hotel.services.impl.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    private final ClienteService clienteService;

    public ClienteResource(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteSaidaDto> salvarCliente(@RequestBody ClienteEntradaDto clienteEntradaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(clienteEntradaDto));
    }
}
