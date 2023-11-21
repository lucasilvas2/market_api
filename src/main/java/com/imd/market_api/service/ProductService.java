package com.imd.market_api.service;

import com.imd.market_api.model.Product;
import com.imd.market_api.model.ProductCreateDTO;
import com.imd.market_api.model.ProductDetailDTO;
import com.imd.market_api.model.ProductUpdateDTO;
import com.imd.market_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAllByAtivoIsTrue();
    }

    public Product findById(Integer id) {
        return productRepository.findByIdAndAtivoIsTrue(id).isPresent() ? productRepository.findByIdAndAtivoIsTrue(id).get() : null;
    }

    public Product create(ProductCreateDTO productCreateDTO) {
        var product = new Product(productCreateDTO);
        productRepository.save(product);
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        var product = productRepository.getReferenceById(id);
        product.setAtivo(false);
    }

    public Product update(ProductUpdateDTO productUpdateDTO) {
        var product = productRepository.getReferenceById(productUpdateDTO.id());
        product.update(productUpdateDTO);
        return product;
    }
}
