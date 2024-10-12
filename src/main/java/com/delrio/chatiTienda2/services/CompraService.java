package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.Compra;
import com.delrio.chatiTienda2.repositories.CompraRepository;

import jakarta.transaction.Transactional;

@Service
public class CompraService {

	@Autowired
	private CompraRepository comprarepositorio;
	@Transactional
	public void guardarCompra(Compra compra) {
		try {
			comprarepositorio.saveCompra(compra.getIdproveedor(),
										 compra.getIdusuario());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar compra "+ e.getMessage());
		}
	}
	
	public List<Compra> getCompras(){
		return comprarepositorio.findAll();
	}
	
	public Optional<Compra> getCompraById(int idcompra){
		return comprarepositorio.findById(idcompra);
	}

}
