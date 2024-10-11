package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Procedure(procedureName="saveCliente")
	void saveClient(int dnicliente,String nombrecliente, int telefonocliente, String emailcliente, String direccioncliente );

}
