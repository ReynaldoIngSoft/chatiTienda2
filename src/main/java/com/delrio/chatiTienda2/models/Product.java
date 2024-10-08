package com.delrio.chatiTienda2.models;

import java.io.Serializable;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_productos")
@Data
@NoArgsConstructor
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproducto")
	private int idproducto;
	
	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 4, max = 80, message ="El nombre de venta debe ser coherente")
	@Column(name="descripcionproducto")
	private String descripcionproducto;
	
	@NotNull(message = "La cantidad no puede ser nula")
	@Min(value = 1, message = "La cantidad debe ser al menos 1")
	@Column(name = "stock")
    private int stock;
	
	@NotNull(message = "El precio de venta no puede ser nulo")
	@PositiveOrZero(message = "el precio de venta debe ser positivo")
	@Column(name = "precioventa")
	private double precioventa;
	
	@NotNull(message ="el valor no puede ser nulo")
	@PositiveOrZero(message= "el precio de la compra no puede ser negativo")
	@Column(name = "preciocompra")
	private double preciocompra;
	
	@NotNull(message = "El ID no puede ser nulo")
	@Column(name = "idtipoproducto")
	private int idtipoproducto;
	
	@NotNull(message = "El Id no puede ser nulo")
	@Column(name = "idproveedor")
    private int idproveedor;
	
	@NotNull(message ="El genero no puede ser nulo")
	@Column(name = "genero")
	private int genero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="genero", insertable = false, updatable = false)
	private Genero objGenero;
	
	 @ManyToOne(fetch =FetchType.EAGER)
	 @JoinColumn(name="idtipoproducto", insertable = false, updatable = false)
	 private TipoProducto objTipo;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "idproveedor", insertable = false, updatable = false)
	 private Proveedor objProveedor;
	 

}
