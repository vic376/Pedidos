package com.senai.weg.Pedidos.mapper;

import com.senai.weg.Pedidos.dto.request.ItemPedidoRequestDto;
import com.senai.weg.Pedidos.dto.response.ItemPedidoResponseDto;
import com.senai.weg.Pedidos.model.ItemPedido;
import com.senai.weg.Pedidos.model.Pedido;

public class ItemPedidoMapper {

    public static ItemPedidoResponseDto toDTO(ItemPedido item) {
        return new ItemPedidoResponseDto(
                Math.toIntExact(item.getId()),
                item.getNomeProduto(),
                item.getQuantidade(),
                item.getPrecoUnitario()
        );
    }

    public static ItemPedido toModel(ItemPedidoRequestDto dto, Pedido pedido) {
        ItemPedido item = new ItemPedido();
        item.setNomeProduto(dto.nomeProduto());
        item.setQuantidade(dto.quantidade());
        item.setPrecoUnitario(dto.precoUnitario());
        item.setPedido(pedido);
        return item;
    }
}
