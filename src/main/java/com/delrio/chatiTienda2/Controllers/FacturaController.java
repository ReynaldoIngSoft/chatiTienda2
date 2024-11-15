package com.delrio.chatiTienda2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delrio.chatiTienda2.models.Factura;
import com.delrio.chatiTienda2.services.FacturaService;

@RestController
@RequestMapping("api/factura")
public class FacturaController {

	@Autowired
	private FacturaService facturaservicio;
	
	@GetMapping("/listar")
	public List<Factura> obtenerFacturas(){
		return facturaservicio.obtenerTodasFacturas();
	}
	
	@PostMapping("/guardar")
	public Factura crearFactura(@RequestBody Factura factura){
		return facturaservicio.guardarFactura(factura);
	} 
}
