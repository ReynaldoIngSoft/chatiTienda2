package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.delrio.chatiTienda2.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Procedure(procedureName = "saveProductos")
	void saveProduct(String descripcionProducto, int stock, double precioventa, double preciocompra, int idtipoproducto, int idproveedor, int genero);
}
