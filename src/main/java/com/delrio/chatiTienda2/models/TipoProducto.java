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
	@Column(name="idtipousuario")
	private int idtipousuario;
	
	@NotNull(message = "ingrese el usuario correspondiente")
	@Column(name="tipousuario")
	private String tipousuario;
}
