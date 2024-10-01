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
@Table(name = "tbProveedor")
@NoArgsConstructor
@Data
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproveedor")
	private int idproveedor;
	
	@NotNull(message = "este campo no puede ser nulo")
	@Size(min =11, max=11, message="el ruc debe tener 11 digitos")
	@Column(name="rucproveedor", length = 11)
	private String rucproveedor;
	
	@NotNull(message = "el nombre no puede ser nulo")
	@Column(name = "nombreprove")
	private String nombreprove;
	
	@NotNull(message = "la direccion no puede ser nula")
	@Size(min = 10, max = 90, message = "la direccion tiene que ser coherente")
	@Column(name = "direccionprove")
	private String direccionprove;
	
	@NotNull(message = "El telefono no puede ser nulo")
	@Size(min=7, max=7, message ="el numero de telefono tiene 9 digitos")
	@Column(name = "telefonoprove")
	private int telefono;
}
