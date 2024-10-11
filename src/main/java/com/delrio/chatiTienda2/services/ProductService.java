package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.Product;
import com.delrio.chatiTienda2.repositories.ProductRepository;
import com.fasterxml.jackson.core.sym.Name;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productorepository;
	
	public List<Product> getChatiProductos(){
		return productorepository.findAll();
	}
	
	public Optional<Product> getChatiProductoById(int id){
		return productorepository.findById(id);
	}
	
	@Transactional
	public void guardarProducto(Product producto){
		try {
			productorepository.saveProduct(producto.getDescripcionproducto(),
					   producto.getStock(),
					   producto.getPrecioventa(),
					   producto.getPreciocompra(),
					   producto.getIdtipoproducto(),
					   producto.getIdproveedor(),
					   producto.getGenero());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar el producto", e);
			
		}
	}
		
}
