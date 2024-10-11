package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delrio.chatiTienda2.models.Usuario;
import com.delrio.chatiTienda2.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorepositorio;
	
	public List<Usuario> getUsuarios(){
		return usuariorepositorio.findAll();
	}
	
	public Optional<Usuario> getUsuarioById(int idusuario){
		return usuariorepositorio.findById(idusuario);
	}
	
	public void guardarUsuario(Usuario usuario) {
		try {
			usuariorepositorio.saveUsuario(usuario.getNombreusuario(), usuario.getDniusuario(), usuario.getIdtipousuario(),usuario.getEstadousuario());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar el usuario"+ e.getMessage());
		}
	}
}
