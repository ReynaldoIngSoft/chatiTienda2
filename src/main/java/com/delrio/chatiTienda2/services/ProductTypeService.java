package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delrio.chatiTienda2.models.ProductType;
import com.delrio.chatiTienda2.repositories.ProductTypeRepository;

@Service
public class ProductTypeService {
		
	@Autowired
	private ProductTypeRepository tipoprodurepository;
	
	
	public List<ProductType> getChatiProductos(){
		return tipoprodurepository.findAll();
	}
	
	public Optional<ProductType> getChatiProductoById(int id){
		return tipoprodurepository.findById(id);
	}
	
	public ProductType saveChatiProducto(ProductType tipoproducto) {
		return tipoprodurepository.save(tipoproducto);
	}
	
	public void deleteChatiProducto(int id) {
		tipoprodurepository.deleteById(id);
	}
}
