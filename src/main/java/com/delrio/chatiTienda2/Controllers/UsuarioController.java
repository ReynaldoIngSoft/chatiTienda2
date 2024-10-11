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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.delrio.chatiTienda2.models.Usuario;
import com.delrio.chatiTienda2.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService serviciousuario;
	
//OBTENER LISTA USUARIOS
	@GetMapping("/obtener")
	public ResponseEntity<?> getUsuarios(){
		try {
			List<Usuario> usuarios = serviciousuario.getUsuarios();
			if (usuarios.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no hay usuarios disponibles");
			}
				return ResponseEntity.status(HttpStatus.OK).body(usuarios);	
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los usuarios:"+e.getMessage());
		}
	}
//GUARDAR USUARIO
	@PostMapping("/save")
	public ResponseEntity<String> saveUsuario(@RequestBody Usuario usuario){
		try {
			serviciousuario.guardarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.OK).body("usuario guardado con exito");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al guardar el usuario "+ e.getMessage());
		}
	}
	
//OBTENER USUARIO POR ID
	@GetMapping("/buscar/{idusuario}")
	public ResponseEntity<?> getUsuario(@PathVariable("idusuario") Integer idusuario){
		try {
			Usuario usuario1 = serviciousuario.getUsuarioById(idusuario).orElse(null);
			if(usuario1 == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("codigo de usuario no encontrado");
			}
			return ResponseEntity.status(HttpStatus.OK).body(usuario1);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidor "+e.getMessage());		
		}
	}
	
}
