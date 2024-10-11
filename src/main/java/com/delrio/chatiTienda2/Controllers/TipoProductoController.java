package com.delrio.chatiTienda2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.delrio.chatiTienda2.models.TipoProducto;
import com.delrio.chatiTienda2.repositories.TipoProductoRepository;
import com.delrio.chatiTienda2.services.TipoProductoService;

@RestController
@RequestMapping("/api/tipoproducto")
public class TipoProductoController {
	
	private final TipoProductoService tipoproductoservicio;
	@Autowired
	public TipoProductoController(TipoProductoService tipoproductoservicio) {
		this.tipoproductoservicio = tipoproductoservicio;
	}
//OBTENER LOS TIPO PRODUCTOS
	@GetMapping("/obtener")
	public ResponseEntity<?> getTipoProductos(){
		try {
			List<TipoProducto> tipoproductos = tipoproductoservicio.getTipoProductos();
			if(tipoproductos.isEmpty()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no es encontraron tipo de proveedores");
			}
			return ResponseEntity.status(HttpStatus.OK).body(tipoproductos);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("el servidor no  responde "+e.getMessage());
		}
	}
//OBTENER TIPO PRODUCTO POR ID
	@GetMapping("/buscar/{idtipoproducto}")
	public ResponseEntity<?> getTipoProducto(@PathVariable("idtipoproducto") Integer idtipoproducto){
		try {
			TipoProducto tipoproducto1 = tipoproductoservicio.getTipoProducto(idtipoproducto).orElse(null);
			if(tipoproducto1 == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("este codigo de producto no se encontro");
			}
			return ResponseEntity.status(HttpStatus.OK).body(tipoproducto1);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro en respuesta de servidor "+e.getMessage());
		}
	}
//GUARDAR TIPOPRODUCTO
	public ResponseEntity<String> saveTipoProducto(@RequestBody TipoProducto tipoproducto){
		try {
			tipoproductoservicio.guardarTipoProducto(tipoproducto);
			return ResponseEntity.status(HttpStatus.OK).body("el tipo de producto se registro exitosamente!!");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error en el servidor "+e.getMessage());
		}
	}
}
