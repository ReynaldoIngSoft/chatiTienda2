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
	
	@NotNull(message ="El genero no puede ser nulo")
	@Pattern(regexp = "M|F", message = "El genero debe ser 'M'o 'F'")
	@Column(name = "genero", nullable = false)
	private Genero genero;
	/*
	idproducto int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	descripcionproducto varchar(255) DEFAULT NULL,
  	stock int DEFAULT NULL,
  	precioventa double DEFAULT NULL,
  	preciocompra double DEFAULT NULL,
  	idtipoproducto int,
  	idproveedor int
  	genero ENUM('M','F') NOT NULL DEFAULT 'F'
	 */
	
	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 4, max = 80, message ="El nombre de venta debe ser coherente")
	@Column(name="nombreprodu")
	private String nombreprodu;
	
	@NotNull(message = "El precio de venta no puede ser nulo")
	@PositiveOrZero(message = "el precio de venta debe ser positivo")
	@Column(name = "precioventaprodu")
	private double precioventa;
	
	@NotNull(message ="el valor no puede ser nulo")
	@PositiveOrZero(message= "el precio de la compra no puede ser negativo")
	@Column(name = "preciocompraprodu")
	private double preciocompra;
	
	@NotNull(message = "La cantidad no puede ser nula")
	@Min(value = 0, message = "La cantidad debe ser al menos 0")
	@Column(name = "cantidad")
    private int cantidad;
	
	@NotNull(message = "El ID no puede ser nulo")
	@Column(name = "idtipoprodu")
	private int idtipoprodu;
	
	@NotNull(message = "El Id no puede ser nulo")
	@Column(name = "idproveedor")
    private int idproveedor;
	
	 @ManyToOne(fetch =FetchType.EAGER)
	 @JoinColumn(name="idtipoprodu", insertable = false, updatable = false)
	 private ProductType objTipo;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "idproveedor", insertable = false, updatable = false)
	 private Supplier objProveedor;
	 
     public enum Genero{
        M, F
    }
}
