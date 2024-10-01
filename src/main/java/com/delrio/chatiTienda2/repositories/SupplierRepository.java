package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.delrio.chatiTienda2.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	
	@Procedure(procedureName = "saveSupplier")
	void saveSupplier(@Param("rucprove")String rucproveedor,
					  @Param("nomprove")String nombreprovee,
					  @Param("direprove")String direccionprovee,
					  @Param("teleprove")int phone);
	
}
