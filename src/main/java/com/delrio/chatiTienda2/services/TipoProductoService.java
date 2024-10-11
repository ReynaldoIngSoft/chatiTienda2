package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.TipoProducto;
import com.delrio.chatiTienda2.repositories.TipoProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoProductoService {

	private final TipoProductoRepository tipoproductorepositorio;
	@Autowired
	public TipoProductoService(TipoProductoRepository tipoproductorepositorio) {
		this.tipoproductorepositorio = tipoproductorepositorio;
	}
	@Transactional
	public void guardarTipoProducto(TipoProducto tipoproducto) {
		try {
			tipoproductorepositorio.saveTipoProducto(tipoproducto.getDescripcionproducto());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar el tipo producto "+e.getMessage());
		}
	}
	
	public List<TipoProducto> getTipoProductos() {
		return tipoproductorepositorio.findAll();
	}
	
	public Optional<TipoProducto> getTipoProducto(int idtipoproducto){
		return tipoproductorepositorio.findById(idtipoproducto);
	}
}
