package com.senai.weg.Pedidos.repository;

import com.senai.weg.Pedidos.model.ItemPedido;
import com.senai.weg.Pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
