package com.delrio.chatiTienda2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Factura {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfactura;

    private int idcliente;

    private Date fechafactura;

    private double total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DetalleFactura> detallefactura;

}
