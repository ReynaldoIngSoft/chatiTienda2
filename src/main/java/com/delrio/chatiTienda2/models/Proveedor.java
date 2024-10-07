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
@Data
@Table(name="tb_proveedor")
@NoArgsConstructor
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproveedor")
	private int idproveedor;
	
	@NotNull(message="El nombre no puede ser nulo o vacio")
	@Size(min = 4, max = 100, message="El nombre no puede estar vacio")
	@Column(name="nombreproveedor")
	private String nombreproveedor; 
	
	@NotNull(message="el ruc tiene que tener minimo 11 digitos")
	@Size(min = 11, max = 11 , message= "el ruc debe tener minimo 11 digitos")
	@Column(name="rucproveedor")
	private int rucproveedor;
	
	@NotNull(message= "la direcciomn no puede ser nula")
	@Column(name="direccionproveedor")
	private String direccionproveedor;
	
	@Size(min = 9, max =9 , message="el numero de telefono debe tener 9 digitos")
	@Column(name="telefonoproveedor")
	private int telefonoproveedor;

}
