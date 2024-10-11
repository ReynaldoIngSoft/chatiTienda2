package com.delrio.chatiTienda2.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delrio.chatiTienda2.models.Cliente;
import com.delrio.chatiTienda2.models.Product;
import com.delrio.chatiTienda2.services.clienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private clienteService clienteservicio;
	
//OBTENER CLIENTE POR ID
	@GetMapping("/buscar/{idcliente}")
	public ResponseEntity<?> getClient(@PathVariable("idcliente") Integer idcliente){
		try {
			Cliente cliente1 = clienteservicio.getClienteById(idcliente).orElse(null);
			if(cliente1 == null){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("codigo de cliente no encontrado");
			}
			return ResponseEntity.status(HttpStatus.OK).body(cliente1);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al obtener el cliente "+e.getMessage());
		}
	}
//GUARDAR CLIENTE
	@PostMapping("/guardar")
	public ResponseEntity<String> saveCliente(@RequestBody Cliente cliente){
		try {
			clienteservicio.guardarClientes(cliente);
			return ResponseEntity.status(HttpStatus.OK).body("cliente guardado con exito");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					             .body("Error al guardar el cliente: "+ e.getMessage());
		}
	}
//OBTENER LISTA DE CLIENTES
	@GetMapping("/obtener")
	public ResponseEntity<?> getClientes(){
		try {
			List<Cliente> clientes = clienteservicio.getClientes();
			if (clientes.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no hay clientes disponibles");
			}
				return ResponseEntity.status(HttpStatus.OK).body(clientes);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los clientes:"+ e.getMessage());
		}
		
	}
}
