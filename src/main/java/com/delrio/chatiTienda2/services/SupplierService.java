package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.ProductType;
import com.delrio.chatiTienda2.models.Supplier;
import com.delrio.chatiTienda2.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierrepository;
	

	public List<Supplier> getSuppliers(){
		return supplierrepository.findAll();
	}
	
	public Optional<Supplier> getSupplierById(int id){
		return supplierrepository.findById(id);
	}
	
	public void saveSupplier(String ruc, String nombre,String direccion, int telefono){
		supplierrepository.saveSupplier(ruc, nombre, direccion, telefono);
	}
	
	public void deleteSupplier(int id) {
		supplierrepository.deleteById(id);
	}
	
	
}
