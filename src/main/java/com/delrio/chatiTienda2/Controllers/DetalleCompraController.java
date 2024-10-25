package com.delrio.chatiTienda2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delrio.chatiTienda2.models.Compra;
import com.delrio.chatiTienda2.models.DetalleCompra;
import com.delrio.chatiTienda2.services.DetalleCompraService;

@RestController
@RequestMapping("/api/detallecompra")
public class DetalleCompraController {
	
	@Autowired
	private DetalleCompraService detallecompraservicio;

//OBTENER LISTADO DE DETALLES COMPRAS
	@GetMapping("/obtener")
	public ResponseEntity<?> getDetallesCompra(){
		
		try {
			List<DetalleCompra> detallecompras = detallecompraservicio.getDetalleCompras();
			if (detallecompras.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("lo detalles de compras estan vacios");
			}
			return ResponseEntity.status(HttpStatus.OK).body(detallecompras);
		}
		catch(Exception e ){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error de servidor "+e.getMessage());
					
		}
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> saveDetalleCompra(@RequestBody DetalleCompra detallecompra){
		try {
			detallecompraservicio.guardarDetalleCompra(detallecompra);
			return ResponseEntity.status(HttpStatus.OK).body("detalle compra registrada");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidor :"+ e.getMessage());
		}
	}

	@GetMapping("/buscar/{idcompra}")
	public ResponseEntity<?> getDetalleCompraId(@PathVariable("idcompra") Integer idcompra){
		try {
			List<DetalleCompra> detallecompralista = detallecompraservicio.getDetallecomprabyIdCompra(idcompra);
					if (detallecompralista.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran detalles con ese id");
					}
					return ResponseEntity.status(HttpStatus.OK).body(detallecompralista);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidior : "+e.getMessage());
			}
	}
}
