package com.delrio.chatiTienda2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="tb_genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgenero")
	private int idgenero;
	
	@NotNull(message="la descripcion no puede ser nula")
	@Column(name="descripciongenero")
	private String descripciongenero;
}
