package com.delrio.chatiTienda2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delrio.chatiTienda2.models.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}
