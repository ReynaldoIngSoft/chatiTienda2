package com.delrio.chatiTienda2.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name="tb_compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcompra")
	private int idcompra;
	
	@CreationTimestamp
	@Column(name="fechacompra")
	private LocalDate fechacompra; 
		
	@Column(name="monto_total")
	private double monto_total;
	
	@NotBlank(message="no puede estar vacio este campo proveedor")
	@Column(name="idproveedor")
	private int idproveedor;
	
	@NotBlank(message="no puede estar vacio este campo usuario")
	@Column(name="idusuario")
	private int idusuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproveedor", insertable= false, updatable = false)
	private Proveedor objProveedor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idusuario", insertable = false, updatable = false)
	private Usuario objUsuario;
}
