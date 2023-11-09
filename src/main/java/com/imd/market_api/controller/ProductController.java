package com.imd.market_api.controller;

import com.imd.market_api.model.ProductCreateDTO;
import com.imd.market_api.model.ProductDetailDTO;
import com.imd.market_api.model.ProductUpdateDTO;
import com.imd.market_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value ="/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDetailDTO>> list(Pageable pageable){
        var list = productService.findAll(pageable).map(ProductDetailDTO::new);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        var product = new ProductDetailDTO(productService.findById(id));
        return ResponseEntity.ok(product);
    }
    
    @PostMapping
    public ResponseEntity create(@RequestBody @Valid ProductCreateDTO productCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        var product = productService.create(productCreateDTO);
        var uri = uriComponentsBuilder.path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDetailDTO(product));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ProductUpdateDTO productUpdateDTO){
        var customers =  productService.update(productUpdateDTO);
        return ResponseEntity.ok(new ProductDetailDTO(customers));
    }
}
