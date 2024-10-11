package com.delrio.chatiTienda2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delrio.chatiTienda2.models.Proveedor;
import com.delrio.chatiTienda2.repositories.ProveedorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProveedorService {
	
	
	private final ProveedorRepository proveedorrepositorio;
	
	@Autowired
	public ProveedorService(ProveedorRepository proveedorrepositorio){
		this.proveedorrepositorio = proveedorrepositorio;
	}
	@Transactional
	public void guardarProveedor(Proveedor proveedor) {
		try {
			proveedorrepositorio.saveProveedor(proveedor.getNombreproveedor(),
											   proveedor.getRucproveedor(),										
											   proveedor.getDireccionproveedor(),
											   proveedor.getTelefonoproveedor());
		}
		catch(Exception e){
			throw new RuntimeException("Error al guardar el proveedor " +e.getMessage());
		}
	}
	public List<Proveedor> getProveedores(){
		return proveedorrepositorio.findAll();
	}
	public Optional<Proveedor> getProveedor(int idproveedor){
		return proveedorrepositorio.findById(idproveedor);
	}
}
