package com.delrio.chatiTienda2.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tb_ventas")
public class Venta {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idventas")
	private int idventas;
	
	@Column(name="fechaventa")
	private Date fechaventa;
	
	@Column(name="montoventa")
	private double montoventa;
	
	
	@Column(name="idcliente")
	private int idcliente;
	
	@Column(name="idusuario")
	private int idusuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idcliente",insertable = false, updatable = false)
	private Cliente objCliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "idusuario", insertable = false, updatable = false)
	private Usuario objUsuario;
	
}
