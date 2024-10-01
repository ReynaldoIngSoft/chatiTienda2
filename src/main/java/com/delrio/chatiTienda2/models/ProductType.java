package com.delrio.chatiTienda2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbTipoProducto")
@Data
@NoArgsConstructor
public class ProductType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipoprodu")
	private int idtipoprodu;
	
	@NotNull
	@Size(min = 1, max = 20, message = "el nombre debe ser coherente")
	@Column(name="nombretipoprodu")
	private String nombreTipo;
	
}
