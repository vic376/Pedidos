package com.senai.weg.Pedidos.controller;

import com.senai.weg.Pedidos.dto.request.ItemPedidoRequestDto;
import com.senai.weg.Pedidos.dto.response.ItemPedidoResponseDto;
import com.senai.weg.Pedidos.model.Pedido;
import com.senai.weg.Pedidos.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService service;

    @PostMapping
    public ItemPedidoResponseDto criarItem(@RequestBody ItemPedidoRequestDto dto) {
        return service.criarItem(dto);
    }

    @GetMapping
    public List<ItemPedidoResponseDto> listarItens() {
        return service.listarItens();
    }

    @GetMapping("/{id}")
    public ItemPedidoResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ItemPedidoResponseDto atualizarItem(@PathVariable Long id, @RequestBody ItemPedidoRequestDto dto) {
        return service.atualizarItem(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Long id) {
        service.deletarItem(id);
    }
}
