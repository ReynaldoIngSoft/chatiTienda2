package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delrio.chatiTienda2.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
