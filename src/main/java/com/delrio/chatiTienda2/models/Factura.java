package com.delrio.chatiTienda2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name="tb_factura")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idfactura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idfactura")
    private int idfactura;

    @Column(name = "idcliente")
    private int idcliente;

    @Column(name = "fechafactura")
    private Date fechafactura;

    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "idfactura", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DetalleFactura> detallefactura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcliente",insertable = false,updatable = false)
    private Cliente objCliente;

}
