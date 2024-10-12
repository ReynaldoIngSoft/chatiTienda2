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
import com.delrio.chatiTienda2.models.tipoUsuario;
import com.delrio.chatiTienda2.services.TipoUsuarioService;

@RestController
@RequestMapping("/api/tipousuario")
public class TipoUsuarioController {
	
	@Autowired
	private TipoUsuarioService tipousuarioservicio;
	
//Obtener tipo usuario por id
  @GetMapping("/buscar/{idtipousuario}")
  public ResponseEntity<?> getTipoUsuario(@PathVariable("idtipousuario") Integer idtipousuario){
	  try {
		  tipoUsuario tipousuario1 = tipousuarioservicio.getTipoUsuario(idtipousuario).orElse(null);
		  if (tipousuario1 == null) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro un tipo de usuario");
		  }
		  return ResponseEntity.status(HttpStatus.OK).body(tipousuario1);
			}
	  catch(Exception e){
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error del servidor :" +e.getMessage());
	  }
  }
//OBTENER LISTA DE TIPO DE USUARIOS
  	@GetMapping("/obtener")
	public ResponseEntity<?> gettipoUsuarios(){
		try {
			List<tipoUsuario> tipousuarios = tipousuarioservicio.getTipoUsuarios();
			if (tipousuarios.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontraron tipo de usuarios");
			}
			return ResponseEntity.status(HttpStatus.OK).body(tipousuarios);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error de servidor "+e.getMessage());
		}
	}
 //GUARDAR TIPO USUARIO
  	@PostMapping("/save")
  	public ResponseEntity<?> saveTipoUsuario(@RequestBody tipoUsuario tipousuario){
  		try {
  			tipousuarioservicio.guardarTipoUsuario(tipousuario);
  			return ResponseEntity.status(HttpStatus.OK).body("tipo usuario guardado con exito");
  		}
  		catch(Exception e){
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error en el servidor "+ e.getMessage());
  		}
  	}
}
