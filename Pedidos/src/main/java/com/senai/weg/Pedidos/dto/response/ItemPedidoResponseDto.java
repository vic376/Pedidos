package com.senai.weg.Pedidos.dto.response;

public record ItemPedidoResponseDto(
        int id,
        String nomeProduto,
        int quantidade,
        double precoUnitario

) {
}
