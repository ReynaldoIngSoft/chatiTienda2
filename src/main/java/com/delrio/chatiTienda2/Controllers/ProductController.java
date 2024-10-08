package com.delrio.chatiTienda2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delrio.chatiTienda2.models.Product;
import com.delrio.chatiTienda2.services.ProductService;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
		
		@Autowired
		private ProductService productoservicio;
		
		
	    @PostMapping("/save")
	    public ResponseEntity<String> saveProduct(@RequestBody Product producto) {
	        // Guardar el producto
	        productoservicio.guardarProducto(producto);
	        
	        return ResponseEntity.ok("Producto registrado con éxito");
	    }
	    
		/*@PostMapping("/save")
		public ResponseEntity<String> saveProduct(
				@RequestParam String descripcionproducto,
				@RequestParam int stock,
				@RequestParam double precioventa,
				@RequestParam double preciocompra,
				@RequestParam int idtipoproducto,
				@RequestParam int idproveedor,
				@RequestParam String genero){
			Product producto = new Product();
			producto.setDescripcionproducto(descripcionproducto);
			producto.setStock(stock);
			producto.setPrecioventa(precioventa);
			producto.setPreciocompra(preciocompra);
			producto.setIdtipoproducto(idtipoproducto);
			producto.setIdproveedor(idproveedor);
			producto.setGenero(Product.Genero.valueOf(genero.toUpperCase()));;
			
			productoservicio.guardarProducto(producto);
			
			return ResponseEntity.ok("Producto registrado con éxito");
		}*/
}
