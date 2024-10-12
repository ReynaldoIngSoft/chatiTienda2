package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
	
	@Procedure(procedureName = "saveCompra")
	void saveCompra(int idproveedor, int idusuario);
}
