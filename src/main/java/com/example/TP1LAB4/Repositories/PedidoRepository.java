package com.example.TP1LAB4.Repositories;

import com.example.TP1LAB4.Entities.Pedido;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long>{

    List<Pedido> findByFechaBetween(LocalDate fechaDesde, LocalDate fechaHasta);
}
