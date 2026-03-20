package com.senai.weg.Pedidos.dto.request;

public record ItemPedidoRequestDto(

        String nomeProduto,
        int quantidade,
        double precoUnitario,
        Long idPedido
) {
}
