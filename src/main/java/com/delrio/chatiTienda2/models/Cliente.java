package com.delrio.chatiTienda2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_clientes")
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcliente")
	private int idcliente;

	@NotNull(message = "el dni no puede estrar vacio")
	@Size(min = 8, max = 8 ,message = "el dni tiene 8 digitos")
	@Column(name="dnicliente")
	private int dnicliente;
	
	@NotBlank(message =  "no debe estar en blanco campo nombre")
	@NotNull(message = "el campo debe estar lleno")
	@Column(name="nombrecliente")
	private String nombrecliente;
	
	@NotBlank(message = "no debe estar en blanco campo telefono")
	@Size(min=9, max=9, message = "el campo telefono debe estar lleno")
	@Column(name="telefonocliente")
	private int telefonocliente;
	
	@NotBlank(message = "no debe estar en blanco campo email")
	@Email(message = "debe ingresar un correo electronico adecuado")
	@Column(name="emailcliente")
	private String emailcliente;
	
	@NotBlank(message = "no debe estar en blanco campo direccion")
	@Column(name="direccioncliente")
	private String direccioncliente;
	
}
