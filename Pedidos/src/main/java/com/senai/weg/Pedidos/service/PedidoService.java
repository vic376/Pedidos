package com.senai.weg.Pedidos.service;

import com.senai.weg.Pedidos.dto.request.PedidoRequest;
import com.senai.weg.Pedidos.model.Pedido;
import com.senai.weg.Pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido criarPedido (Pedido pedido){
        return repository.save(pedido);
    }

    public void apagarPedido(Long id){
        repository.deleteById(id);
    }

    public List<Pedido> listarPedido(){
        return repository.findAll();
    }

    public Optional<Pedido> listarPorId(Long id){
        return repository.findById(id);
    }

    public Pedido atualizarPedido(Long id, PedidoRequest dto) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return repository.save(pedido);
    }
}