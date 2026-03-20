package com.senai.weg.Pedidos.controller;

import com.senai.weg.Pedidos.dto.request.PedidoRequest;
import com.senai.weg.Pedidos.model.Pedido;
import com.senai.weg.Pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;

    @PostMapping
    public Pedido criarPedido (@RequestBody Pedido pedido){
        return service.criarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void apagarPedido(@PathVariable Long id){
        service.apagarPedido(id);
    }

    @PutMapping("/{id}")
    public Pedido atualizarPedido(@PathVariable Long id, @RequestBody PedidoRequest dto){
        return service.atualizarPedido(id, dto);
    }

    @GetMapping
    public List<Pedido> listarPedido(){
        return service.listarPedido();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPedido(@PathVariable Long id) {
        return service.listarPorId(id);
    }
}

