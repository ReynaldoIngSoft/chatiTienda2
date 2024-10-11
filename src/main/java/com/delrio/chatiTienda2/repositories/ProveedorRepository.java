package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
	@Procedure(procedureName = "saveProveedor")
	void saveProveedor(String nombreproveedor, String rucproveedor,String direccionproveedor,String telefonoproveedor); 
					   
					   
}
