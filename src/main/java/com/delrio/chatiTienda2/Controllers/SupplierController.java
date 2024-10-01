package com.delrio.chatiTienda2.Controllers;

import java.util.List;
import com.delrio.chatiTienda2.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delrio.chatiTienda2.services.SupplierService;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {

	
	@Autowired
	private SupplierService supplierservice;
	
	
	@GetMapping("/lista")
	public List<Supplier> getAllSuppliers(){
		return supplierservice.getSuppliers();
	}
	
	@PostMapping("/save")
	public void addSupplier(@RequestParam String ruc,
							@RequestParam String nom,
							@RequestParam String dire,
							@RequestParam int fono) {
		supplierservice.saveSupplier(ruc, nom, dire, fono);
	}
}
