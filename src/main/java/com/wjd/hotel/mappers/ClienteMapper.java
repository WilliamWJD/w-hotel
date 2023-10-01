package com.wjd.hotel.mappers;

import com.wjd.hotel.domain.Cliente;
import com.wjd.hotel.dtos.ClienteEntradaDto;
import com.wjd.hotel.dtos.ClienteSaidaDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ClienteMapper {
    public Cliente deClienteEntradaDtoParaClienteEntidade(ClienteEntradaDto clienteEntradaDto) {
        Cliente cliente = new Cliente();

        if (Objects.nonNull(clienteEntradaDto.getId())) {
            cliente.setId(clienteEntradaDto.getId());
        }

        cliente.setNome(clienteEntradaDto.getNome());
        cliente.setCpf(clienteEntradaDto.getCpf());
        cliente.setEmail(clienteEntradaDto.getEmail());
        return cliente;
    }

    public ClienteSaidaDto deClienteEntidadeParaClienteSaidaDto(Cliente cliente) {
        ClienteSaidaDto clienteSaidaDto = new ClienteSaidaDto();

        clienteSaidaDto.setId(cliente.getId());
        clienteSaidaDto.setNome(cliente.getNome());
        clienteSaidaDto.setEmail(cliente.getEmail());

        return clienteSaidaDto;
    }

    public Cliente deClienteSaidaDtoParaClienteEntidade(ClienteSaidaDto clienteSaidaDto){
        return new Cliente(clienteSaidaDto.getId(), clienteSaidaDto.getNome(), clienteSaidaDto.getEmail(), null);
    }
}
