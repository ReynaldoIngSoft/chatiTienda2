package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Procedure(procedureName ="saveUsuarios")
	void saveUsuario(String nombreusuario, int dniusuario, int idtipousuario, int estadousuario);
	
}
