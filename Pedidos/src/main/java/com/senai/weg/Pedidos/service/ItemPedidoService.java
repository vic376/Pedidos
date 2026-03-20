package com.senai.weg.Pedidos.service;

import com.senai.weg.Pedidos.dto.request.ItemPedidoRequestDto;
import com.senai.weg.Pedidos.dto.response.ItemPedidoResponseDto;
import com.senai.weg.Pedidos.mapper.ItemPedidoMapper;
import com.senai.weg.Pedidos.model.ItemPedido;
import com.senai.weg.Pedidos.model.Pedido;
import com.senai.weg.Pedidos.repository.ItemPedidoRepository;
import com.senai.weg.Pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedidoResponseDto criarItem(ItemPedidoRequestDto dto) {
        Pedido pedido = pedidoRepository.findById(dto.idPedido())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        ItemPedido item = ItemPedidoMapper.toModel(dto, pedido);
        ItemPedido salvo = itemPedidoRepository.save(item);
        return ItemPedidoMapper.toDTO(salvo);
    }

    public List<ItemPedidoResponseDto> listarItens() {
        return itemPedidoRepository.findAll()
                .stream()
                .map(ItemPedidoMapper::toDTO)
                .toList();
    }

    public ItemPedidoResponseDto buscarPorId(Long id) {
        ItemPedido item = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        return ItemPedidoMapper.toDTO(item);
    }

    public ItemPedidoResponseDto atualizarItem(Long id, ItemPedidoRequestDto dto) {
        ItemPedido item = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        item.setNomeProduto(dto.nomeProduto());
        item.setQuantidade(dto.quantidade());
        item.setPrecoUnitario(dto.precoUnitario());

        return ItemPedidoMapper.toDTO(itemPedidoRepository.save(item));
    }

    public void deletarItem(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}