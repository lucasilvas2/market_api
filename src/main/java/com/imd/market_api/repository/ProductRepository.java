package com.imd.market_api.repository;

import com.imd.market_api.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByAtivoIsTrue();
    Optional<Product> findByIdAndAtivoIsTrue(Integer id);
}
