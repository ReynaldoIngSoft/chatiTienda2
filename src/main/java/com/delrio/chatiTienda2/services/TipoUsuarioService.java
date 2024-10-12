package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.tipoUsuario;
import com.delrio.chatiTienda2.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	private final TipoUsuarioRepository tipousuariorepositorio;
	@Autowired
	public TipoUsuarioService(TipoUsuarioRepository tipousuariorepository) {
		this.tipousuariorepositorio = tipousuariorepository;
	}
	
	public void guardarTipoUsuario(tipoUsuario tipousuario) {
		try {
			tipousuariorepositorio.saveTipoUsuario(tipousuario.getTipousuario());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar  el tipo usuario "+e.getMessage());
			
		}
	}
	
	public List<tipoUsuario> getTipoUsuarios(){
		return tipousuariorepositorio.findAll();
	}
	
	public Optional<tipoUsuario> getTipoUsuario(int idtipousuario){
		return tipousuariorepositorio.findById(idtipousuario);
	}
	
}
