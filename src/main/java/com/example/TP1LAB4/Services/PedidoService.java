package com.example.TP1LAB4.Services;

import com.example.TP1LAB4.Entities.Pedido;
import com.example.TP1LAB4.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {
    List<Pedido> findByFechaBetween(LocalDate fechaDesde, LocalDate fechaHasta);
}
