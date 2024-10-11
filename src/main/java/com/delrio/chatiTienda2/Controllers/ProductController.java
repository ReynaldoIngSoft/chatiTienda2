package com.delrio.chatiTienda2.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
//OBTENER PRODUCTOS
		@GetMapping("/productos")
		public ResponseEntity<?> getProducts(){
			try {
				return ResponseEntity.status(HttpStatus.OK).body(productoservicio.getChatiProductos());
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		}

//GUARDAR PRODUCTO	
	    @PostMapping("/save")
	    public ResponseEntity<String> saveProduct(@RequestBody Product producto) {
	    	
	    	try {
	    		productoservicio.guardarProducto(producto);
	    		return ResponseEntity.status(HttpStatus.CREATED).body("Producto guardado con éxito");
	    	}
	    	catch(Exception e){
	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Inesperado: " +e.getMessage());
	    	}
	    }
//BUSCAR PRODUCTO POR ID
	    @GetMapping("/buscar/{idproducto}")
	    public Product getProducto(@PathVariable("idproducto") Integer idproducto){
	    	try {
	    		Product producto1 = productoservicio.getChatiProductoById(idproducto).orElse(null);
	    		return  producto1;
	    		
	    	}
	    	catch(Exception e){
	    		return null;
	    	}
	      }
		}
