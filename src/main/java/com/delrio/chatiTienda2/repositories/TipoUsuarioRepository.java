package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.tipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<tipoUsuario, Integer> {
	
	@Procedure(procedureName = "saveTipoUsuario")
	void saveTipoUsuario(String tipousuario);
}
