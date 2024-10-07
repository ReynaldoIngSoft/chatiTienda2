package com.delrio.chatiTienda2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name="tb_detalle_ventas")
public class DetalleVenta {
	
	@Id
	@Column(name="iddetalleventas")
	private int  iddetalleventas;
	
	@Column(name="idproducto")
	private int idproducto;
	
	@Column(name="idventas")
	private int idventas;
	
	@Column(name="precioventa")
	private double precioventa;
	
	@Min(1)
	@Column(name="cantidad")
	private int cantidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idproducto", updatable=false, insertable = false)
	private Product objProducto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idventas", updatable = false, insertable = false)
	private Venta objVenta;
}
