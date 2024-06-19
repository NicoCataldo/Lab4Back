package com.example.TP1LAB4.Gestor;

import com.example.TP1LAB4.Entities.Pedido;
import com.example.TP1LAB4.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private PedidoService pedidoService; // Debes tener un servicio para manejar los pedidos

    @GetMapping("/pedidos")
    public ResponseEntity<InputStreamResource> downloadPedidosExcel(
            @RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta) throws Exception {

        // Obtener lista de pedidos desde el servicio
        List<Pedido> pedidos = pedidoService.findByFechaBetween(fechaDesde, fechaHasta);

        // Generar el archivo Excel
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        excelService.exportPedidosToExcel(pedidos, out);

        // Preparar para la descarga
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=pedidos_" + fechaDesde + "_to_" + fechaHasta + ".xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}


