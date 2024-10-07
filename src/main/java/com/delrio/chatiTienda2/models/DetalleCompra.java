package com.delrio.chatiTienda2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_detalle_compras")
@NoArgsConstructor
public class DetalleCompra {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iddetallecompra")
	@Id
	private  int iddetallecompra;
	
	
	
	@NotNull(message="no dejar en blanco el codigo producto")
	@Column(name="idproducto")
	private int idproducto;
	
	@NotNull(message="id de compra no ingresado")
	@Column(name="idcompra")
	private int idcompra;
	
	@NotNull(message="debe ingresar el campo precio compra")
	@Column(name="preciocompra")
	private double preciocompra;
	
	@NotNull(message="debe ingresar el campo precio venta")
	@Column(name="precioventa")
	private double precioventa;
	
	@Min(1)
	@Column(name="cantidad")
	private int cantidad;
	
	
	
}