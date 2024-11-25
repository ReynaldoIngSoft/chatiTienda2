package com.delrio.chatiTienda2.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delrio.chatiTienda2.models.DetalleFactura;
import com.delrio.chatiTienda2.models.Factura;
import com.delrio.chatiTienda2.models.Product;
import com.delrio.chatiTienda2.repositories.DetalleFacturaRepository;
import com.delrio.chatiTienda2.repositories.FacturaRepository;
import com.delrio.chatiTienda2.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {
	
	@Autowired
	private FacturaRepository facturarepositorio;
	
	@Autowired
	private DetalleFacturaRepository detallerepositorio;
	
	@Autowired
	private ProductRepository productorepositorio;
	
	public List<Factura> obtenerTodasFacturas(){
		return facturarepositorio.findAll();
	}
	
	@Transactional
	public Factura guardarFactura(Factura factura) {
		double  total =factura.getDetallefactura().stream().mapToDouble(DetalleFactura::getSubtotal).sum();
		factura.setTotal(total);
		return facturarepositorio.save(factura);
	}
	
	
	public Optional<Product> obtenerProducto(int idproducto) {
		Optional<Product> producto = productorepositorio.findById(idproducto);
		return producto;
	}
	
	
}
