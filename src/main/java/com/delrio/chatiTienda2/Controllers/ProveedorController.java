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

import com.delrio.chatiTienda2.models.Proveedor;
import com.delrio.chatiTienda2.services.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController{
	
	@Autowired
	private ProveedorService proveedorservicio;
//OBTENER PROVEEDOR POR ID
	@GetMapping("/buscar/{idproveedor}")
	public ResponseEntity<?> getProveedor(@PathVariable("idproveedor") Integer idproveedor){
		try {
			Proveedor proveedor1 = proveedorservicio.getProveedor(idproveedor).orElse(null);
			if(proveedor1== null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("codigo de proveedor no encontrado");
			}
			return ResponseEntity.status(HttpStatus.OK).body(proveedor1);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al obtener el proveedor "+e.getMessage());
		}
	}
//OBTENER TOOS LOS PROVEEDORES
	@GetMapping("/obtener")
	public ResponseEntity<?> getProveedores(){
		try {
			List<Proveedor> proveedores = proveedorservicio.getProveedores();
			if(proveedores.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no existen registros de proveedores ");
			}
			return ResponseEntity.status(HttpStatus.OK).body(proveedores);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidor "+e.getMessage());
		}
	}
//GUARDAR PROVEEDOR
	@PostMapping("/guardar")
	public ResponseEntity<String> saveProveedor(@RequestBody Proveedor proveedor){
		try {
			proveedorservicio.guardarProveedor(proveedor);
			return ResponseEntity.status(HttpStatus.OK).body("proveedor guardado con exito");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar proveedor :" +e.getMessage());
		}
	}
	
}
