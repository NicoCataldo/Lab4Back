package com.example.TP1LAB4.Gestor;

import com.example.TP1LAB4.Entities.Pedido;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelService {

    public void exportPedidosToExcel(List<Pedido> pedidos, OutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Pedidos");

        // Crear el encabezado
        String[] headers = {"Fecha Pedido", "Instrumento", "Marca", "Modelo", "Cantidad", "Precio", "Total"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Llenar los datos de los pedidos
        int rowNum = 1;
        for (Pedido pedido : pedidos) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(pedido.getFecha().toString());
            row.createCell(1).setCellValue(pedido.getDetalle().getInstrumento().getInstrumento());
            row.createCell(2).setCellValue(pedido.getDetalle().getInstrumento().getMarca());
            row.createCell(3).setCellValue(pedido.getDetalle().getInstrumento().getModelo());
            row.createCell(4).setCellValue(pedido.getDetalle().getCantidad());
            row.createCell(5).setCellValue(pedido.getDetalle().getInstrumento().getPrecio());
            row.createCell(6).setCellValue(pedido.getTotalPedido());
        }

        // Escribir el archivo en el OutputStream
        workbook.write(outputStream);
        workbook.close();
    }
}


