package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.delrio.chatiTienda2.models.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
