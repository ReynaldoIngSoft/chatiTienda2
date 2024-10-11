package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.TipoProducto;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {

	@Procedure(procedureName = "saveTipoProdu")
	void saveTipoProducto(String descripcionproducto);
}
