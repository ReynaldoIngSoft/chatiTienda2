package com.delrio.chatiTienda2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.DetalleCompra;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer>{

	@Procedure(procedureName ="saveDetalleCompra")
	void saveDetalleCompra(int iddetallecompra, int idproducto, double preciocompra, int cantidad);
	
	List<DetalleCompra> findByIdcompra(int idcompra);
}
