package com.senai.weg.Pedidos.mapper;

import com.senai.weg.Pedidos.dto.request.PedidoRequest;
import com.senai.weg.Pedidos.dto.response.PedidoResponse;
import com.senai.weg.Pedidos.model.Pedido;

import java.sql.Date;

public class PedidoMapper {

    public static PedidoResponse toDTO (Pedido pedido){
        return new PedidoResponse(
                pedido.getId(),
                pedido.getDataPedido()


        );
    }

    public static Pedido toModel (PedidoRequest dto){
        Pedido pedido = new Pedido();


        return pedido;
    }
}


