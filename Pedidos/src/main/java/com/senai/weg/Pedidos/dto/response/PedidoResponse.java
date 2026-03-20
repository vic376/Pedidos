package com.senai.weg.Pedidos.dto.response;

import java.sql.Date;

public record PedidoResponse(

        long id,
        Date dataPedido
) {
}
