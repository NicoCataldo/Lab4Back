package com.example.TP1LAB4.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Pedido")
public class Pedido extends Base{
    private LocalDate fecha;
    private double totalPedido;
    private boolean activo;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Detalle_id")
    private DetallePedido detalle;

}
