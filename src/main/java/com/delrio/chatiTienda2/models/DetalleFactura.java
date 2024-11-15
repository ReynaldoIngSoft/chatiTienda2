package com.delrio.chatiTienda2.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detalle_factura")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iddetalle")
public class DetalleFactura {

    @Id
    @Column(name = "iddetalle")
    private int iddetalle;

    @Column(name="idfactura")
    private int idfactura;

    @Column(name = "idproducto")
    private int idproducto;

    @Column(name="descripcion")
    private String descripcion;

    @Min(value = 1)
    @Column(name = "cantidad",nullable = false)
    private int cantidad;

    @Column(nullable = false, name="precio")
    private double precio;


    @Column(nullable = false, name="subtotal")
    private double subtotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idproducto",insertable = false,updatable = false)
    private Product objProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idfactura",insertable = false,updatable = false)
    private Factura objFactura;

}
