package com.wjd.hotel.services.impl;

import com.wjd.hotel.dtos.ClienteEntradaDto;
import com.wjd.hotel.dtos.ClienteSaidaDto;
import com.wjd.hotel.exceptions.impl.DataIntegrityViolationExceptionApp;
import com.wjd.hotel.mappers.ClienteMapper;
import com.wjd.hotel.repository.ClienteRepository;
import com.wjd.hotel.services.ClienteService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteSaidaDto salvarCliente(ClienteEntradaDto clienteEntradaDto) {
        try {
            return clienteMapper.deClienteEntidadeParaClienteSaidaDto(clienteRepository.save(clienteMapper.deClienteEntradaDtoParaClienteEntidade(clienteEntradaDto)));
        } catch (DataIntegrityViolationException err) {
            throw new DataIntegrityViolationExceptionApp("Conflito na base de dados");
        }
    }
}
