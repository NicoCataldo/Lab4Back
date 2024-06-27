package com.example.TP1LAB4;

import com.example.TP1LAB4.Entities.*;
import com.example.TP1LAB4.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Date;


@SpringBootApplication
public class Tp1Lab4Application {
	@Autowired
	InstrumentoRepository instrumentoRepository;
	@Autowired
	CategoriasRepository categoriasRepository;

	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	public static void main(String[] args) {
		SpringApplication.run(Tp1Lab4Application.class, args);
		System.out.println("----------Estoy Funcionando----------");
	}
	@Bean
	CommandLineRunner init(InstrumentoRepository instrumentoRepository, CategoriasRepository categoriasRepository,
						   DetallePedidoRepository detallePedidoRepository,
							PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			/*
			Categorias categoria1 = Categorias.builder()
					.denominacion("Cuerda")
					.build();

			Categorias categoria2 = Categorias.builder()
					.denominacion("Viento")
					.build();
			Categorias categoria3 = Categorias.builder()
					.denominacion("Percusion")
					.build();

			Categorias categoria4 = Categorias.builder()
					.denominacion("Teclado")
					.build();

			Categorias categoria5 = Categorias.builder()
					.denominacion("Electronico")
					.build();
			categoriasRepository.save(categoria1);
			categoriasRepository.save(categoria2);
			categoriasRepository.save(categoria3);
			categoriasRepository.save(categoria4);
			categoriasRepository.save(categoria5);
			Instrumento instrumento1 = Instrumento.builder()
					.instrumento("Mandolina Instrumento Musical Stagg Sunburst")
					.marca("Stagg")
					.modelo("M20")
					.imagen("https://http2.mlstatic.com/D_843554-MLU73703142465_122023-C.jpg")
					.precio(2450f)
					.costo(100f)
					.costoEnvio("G")
					.cantidadVendida(28)
					.descripcion("Estas viendo una excelente mandolina de la marca Stagg.")
					.categoria(categoria1)
					.build();
			instrumentoRepository.save(instrumento1);

			Instrumento instrumento2 = Instrumento.builder()
					.instrumento("Pandereta Pandero Instrumento Musical ")
					.marca("DyM ventas")
					.modelo("32 sonajas")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_895881-MLA69104523759_042023-O.webp")
					.precio(325f)
					.costo(200f)
					.costoEnvio("150")
					.cantidadVendida(10)
					.descripcion(" Pandereta - 32 sonajas metálicas. Más de 8 años vendiendo con 100 % de calificaciones POSITIVAS y clientes satisfechos !! ")
					.categoria(categoria3)
					.build();
			instrumentoRepository.save(instrumento2);

			Instrumento instrumento3 = Instrumento.builder()
					.instrumento("Triangulo Musical 24 Cm Percusion")
					.marca("LBP")
					.modelo("24")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_793682-MLA45982223244_052021-O.webp")
					.precio(260f)
					.costo(100f)
					.costoEnvio("250")
					.cantidadVendida(3)
					.descripcion("Triangulo Musical de 24 Centímetros De Acero.")
					.categoria(categoria3)
					.build();
			instrumentoRepository.save(instrumento3);

			Instrumento instrumento4 = Instrumento.builder()
					.instrumento("Bar Chimes Lp Cortina Musical 72 Barras")
					.marca("FM")
					.modelo("LATIN")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_838108-MLA31575605575_072019-O.webp")
					.precio(2250f)
					.costo(1000f)
					.costoEnvio("G")
					.cantidadVendida(2)
					.descripcion("BARCHIME CORTINA MUSICAL DE 25 BARRAS LATIN CUSTOM. Emitimos factura A y B")
					.categoria(categoria3)
					.build();
			instrumentoRepository.save(instrumento4);

			Instrumento instrumento5 = Instrumento.builder()
					.instrumento("Shekeres. Instrumento. Música. Artesanía.")
					.marca("Azalea Artesanías")
					.modelo("Cuentas de madera")
					.imagen("https://galeriaartesanalpr.com/cdn/shop/files/SHEKERE800LOGO1_b57b606d-b046-49c2-83cf-1819de952cec_600x.jpg?v=1693183399")
					.precio(850f)
					.costo(500f)
					.costoEnvio("300")
					.categoria(categoria3)
					.cantidadVendida(5)
					.descripcion("Las calabazas utilizadas para nuestras artesanías son sembradas y cosechadas por nosotros, quienes seleccionamos el mejor fruto para garantizar la calidad del producto y ofrecerle algo creativo y original.")
					.build();
			instrumentoRepository.save(instrumento5);

			Instrumento instrumento6 = Instrumento.builder()
					.instrumento("Antiguo Piano Aleman Con Candelabros.")
					.marca("Neumeyer")
					.modelo("Stratus")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_741625-MLA25468412771_032017-O.webp")
					.precio(17000f)
					.costo(10000f)
					.costoEnvio("2000")
					.cantidadVendida(0)
					.categoria(categoria4)
					.descripcion("Buen dia! Sale a la venta este Piano Alemán Neumeyer con candelabros incluidos. Tiene una talla muy bonita en la madera. Una pieza de calidad.")
					.build();

			instrumentoRepository.save(instrumento6);

			Instrumento instrumento7 = Instrumento.builder()
					.instrumento("Guitarra Ukelele Infantil Grande 60cm")
					.marca("GUITARRA")
					.modelo("UKELELE")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_602949-MLA32297056646_092019-O.webp")
					.precio(500f)
					.costo(100f)
					.costoEnvio("G")
					.cantidadVendida(5)
					.categoria(categoria1)
					.descripcion("Material	: Plástico similar a madera. 4 Cuerdas longitud: 60cm, el mejor regalo para usted, su familia y amigos, adecuado para 3-18 años de edad.")
					.build();
			instrumentoRepository.save(instrumento7);

			Instrumento instrumento8 = Instrumento.builder()
					.instrumento("Teclado Organo Electronico Musical Instrumento 54 Teclas")
					.marca("GADNIC")
					.modelo("T01")
					.imagen("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUuXmqWnIka9SoIOmPpSPTWC4u07HY4FkCKw&s")
					.precio(2250f)
					.costo(1200f)
					.costoEnvio("G")
					.cantidadVendida(13)
					.categoria(categoria5)
					.descripcion("Organo Electrónico GADNIC T01. Display de Led. 54 Teclas. 100 Timbres / 100 Ritmos. 4 1/2 octavas. 8 Percusiones. 8 Canciones de muestra. Grabación y reproducción. Entrada para Micrófono.")
					.build();
			instrumentoRepository.save(instrumento8);

			Instrumento instrumento9 = Instrumento.builder()
					.instrumento("Instrumentos De Percusión Niños Set Musical Con Estuche")
					.marca("KNIGHT")
					.modelo("LB17")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_773874-MLA52856983256_122022-O.webp")
					.precio(2700f)
					.costo(1500f)
					.costoEnvio("300")
					.categoria(categoria3)
					.cantidadVendida(15)
					.descripcion("Estas viendo un excelente y completísimo set de percusión para niños con estuche rígido, equipado con los instrumentos más divertidos! ")
					.build();
			instrumentoRepository.save(instrumento9);

			Instrumento instrumento10 = Instrumento.builder()
					.instrumento("Batería Musical Infantil Juguete Niño 9 Piezas Palillos")
					.marca("Bateria")
					.modelo("Infantil")
					.imagen("https://http2.mlstatic.com/D_NQ_NP_643960-MLA27368744727_052018-O.webp")
					.precio(850)
					.costo(500f)
					.costoEnvio("250")
					.cantidadVendida(17)
					.categoria(categoria3)
					.descripcion("DESCRIPCIÓN: DE 1 A 3 AÑOS. EL SET INCLUYE 5 TAMBORES, PALILLOS Y EL PLATILLO TAL CUAL LAS FOTOS. SONIDOS REALISTAS Y FÁCIL DE MONTAR. MEDIDAS: 40X20X46 CM")
					.build();
			instrumentoRepository.save(instrumento10);

			Usuario usuario1 = Usuario.builder()
					.usuario("nico")
					.clave("123456")
					.rol(Roles.ADMIN)
					.build();
			usuarioRepository.save(usuario1);

			Usuario usuario2 = Usuario.builder()
					.usuario("visitante")
					.rol(Roles.USER)
					.clave("123456")
					.build();
			usuarioRepository.save(usuario2);

			DetallePedido detalle1 = DetallePedido.builder()
					.cantidad(2)
					.instrumento(instrumento10)
					.build();

			Pedido pedido1 = Pedido.builder()
					.totalPedido(2222)
					.fecha(LocalDate.of(2024,4,23))
					.detalle(detalle1)
					.activo(false)
					.build();

			pedidoRepository.save(pedido1);

			DetallePedido detalle2 = DetallePedido.builder()
					.cantidad(1)
					.instrumento(instrumento1)
					.build();

			Pedido pedido2 = Pedido.builder()
					.totalPedido(instrumento1.getPrecio())
					.fecha(LocalDate.of(2024,3,23))
					.detalle(detalle2)
					.activo(false)
					.build();

			pedidoRepository.save(pedido2);

			DetallePedido detalle3 = DetallePedido.builder()
					.cantidad(1)
					.instrumento(instrumento4)
					.build();

			Pedido pedido3 = Pedido.builder()
					.totalPedido(instrumento4.getPrecio())
					.fecha(LocalDate.of(2024,2,1))
					.detalle(detalle3)
					.activo(false)
					.build();

			pedidoRepository.save(pedido3);

			DetallePedido detalle4 = DetallePedido.builder()
					.cantidad(1)
					.instrumento(instrumento5)
					.build();

			Pedido pedido4 = Pedido.builder()
					.totalPedido(instrumento5.getPrecio())
					.fecha(LocalDate.of(2024,6,23))
					.detalle(detalle4)
					.activo(false)
					.build();

			pedidoRepository.save(pedido4);

			DetallePedido detalle5 = DetallePedido.builder()
					.cantidad(1)
					.instrumento(instrumento7)
					.build();

			Pedido pedido5 = Pedido.builder()
					.totalPedido(instrumento7.getPrecio())
					.fecha(LocalDate.of(2024,6,5))
					.detalle(detalle5)
					.activo(false)
					.build();

			pedidoRepository.save(pedido5);

			DetallePedido detalle6 = DetallePedido.builder()
					.cantidad(1)
					.instrumento(instrumento8)
					.build();

			Pedido pedido6 = Pedido.builder()
					.totalPedido(instrumento6.getPrecio())
					.fecha(LocalDate.of(2024,2,3))
					.detalle(detalle6)
					.activo(false)
					.build();

			pedidoRepository.save(pedido6);


			*/

		};
	}
	
}
