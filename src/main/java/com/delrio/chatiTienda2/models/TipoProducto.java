package com.delrio.chatiTienda2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_tipo_producto")
@Data
@NoArgsConstructor
public class TipoProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtipoproducto")
	private int idtipoproducto;
	
	@NotNull(message = "ingrese la descripcion del tipo de producto")
	@Column(name="descripcionproducto")
	private String descripcionproducto;
}
