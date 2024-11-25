package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delrio.chatiTienda2.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import com.delrio.chatiTienda2.models.Cliente;


@Service
public class clienteService {
	
	@Autowired
	private ClienteRepository clienterepositorio;
	

	public void  guardarClientes(Cliente cliente) {
		try {
			 clienterepositorio.saveClient(cliente.getDnicliente(), cliente.getNombrecliente(),cliente.getTelefonocliente(),cliente.getEmailcliente(), cliente.getDireccioncliente());
			
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar el producto" + e.getMessage());
		}
	
	}
	
	public List<Cliente> getClientes() {
		return clienterepositorio.findAll();
	}
	
	public Optional<Cliente> getClienteById(int idcliente){
		return clienterepositorio.findById(idcliente);
	}
}
