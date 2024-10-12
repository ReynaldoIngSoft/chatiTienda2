package com.delrio.chatiTienda2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.delrio.chatiTienda2.services.CompraService;
import com.delrio.chatiTienda2.models.Compra;

@RestController
@RequestMapping("/api/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraservice;

//OBTENER COMPRA POR ID
	@GetMapping("/buscar/{idcompra}")
	public ResponseEntity<?> getCompraId(@PathVariable("idcompra") Integer idcompra){
		try {
			Compra compra1 = compraservice.getCompraById(idcompra).orElse(null);
			if(compra1 == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se enctro el cod compra");
			}
			return ResponseEntity.status(HttpStatus.OK).body(compra1);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidor "+e.getMessage());
		}
	}
// GUARDAR COMPRA
	@PostMapping("/guardar")
	public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
		try {
			compraservice.guardarCompra(compra);
			return ResponseEntity.status(HttpStatus.OK).body("compra registrada con exito");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidor "+e.getMessage());
		}
	}
//OBTENER LAS COMPRAS
	@GetMapping("/obtener")
	public ResponseEntity<?> getCompras(){
		try {
			List<Compra> compras = compraservice.getCompras();
			if(compras.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro registros de compras");
			}
			return ResponseEntity.status(HttpStatus.OK).body(compras);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("el servidor no responde "+ e.getMessage());
		}
	}
}
