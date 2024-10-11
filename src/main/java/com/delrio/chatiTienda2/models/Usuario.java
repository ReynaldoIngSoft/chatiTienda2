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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_usuario")
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private int idusuario;
	
	@NotBlank(message="no puede estar en blanco este campo nombre")
	@Column(name="nombreusuario")
	private String nombreusuario;
	
	@NotBlank(message ="no piuede estar en blanmco este campo dni")
	@Size(min=8, max= 8, message="el dni debe tener minimo 8 digitos")
	@Column(name="dniusuario")
	private int dniusuario;
	
	@NotBlank(message = "el tipo usuario no puede estar en blanco")
	@Column(name="idtipousuario")
	private int idtipousuario;
	
	@NotBlank(message="el estado del usuario no deberia estar en blanco ")
	@Column(name="estadousuario")
	private int estadousuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idtipousuario", insertable = false, updatable = false)
	private tipoUsuario objTipoUsu;
	
}
