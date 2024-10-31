package com.delrio.chatiTienda2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddetallefactura;
    private int cantidad;
    private double precio;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name="idfactura")
    private Factura factura;
}
