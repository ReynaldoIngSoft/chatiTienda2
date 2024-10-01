package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.Product;
import com.delrio.chatiTienda2.repositories.ProductRepository;

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
	
	public Product saveChatiProducto(Product chatiproducto) {
		return productorepository.save(chatiproducto);
	}
	
	public void deleteChatiProducto(int id) {
		productorepository.deleteById(id);
	}
}
