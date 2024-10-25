package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.DetalleCompra;
import com.delrio.chatiTienda2.repositories.DetalleCompraRepository;

import jakarta.transaction.Transactional;

@Service
public class DetalleCompraService {
	
	@Autowired
	private DetalleCompraRepository detallecomprarepositorio;

	@Transactional
	public void guardarDetalleCompra(DetalleCompra detallecompra) {
		try {
			detallecomprarepositorio.saveDetalleCompra(detallecompra.getIddetallecompra(),
													   detallecompra.getIdproducto(),
													   detallecompra.getPreciocompra(),
													   detallecompra.getCantidad());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar el detalle compra"+ e.getMessage());
		}
	}
	
	public List<DetalleCompra> getDetalleCompras(){
		return detallecomprarepositorio.findAll();
	}
	
	
	public List<DetalleCompra> getDetallecomprabyIdCompra(int idcompra){
		return detallecomprarepositorio.findByIdcompra(idcompra);
	}
}
