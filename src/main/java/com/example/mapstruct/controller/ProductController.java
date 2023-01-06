package com.example.mapstruct.controller;

import com.example.mapstruct.dto.ProductDto;
import com.example.mapstruct.entity.Product;
import com.example.mapstruct.exception.ResourceNotFoundException;
import com.example.mapstruct.mapping.ProductMapper;
import com.example.mapstruct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;



    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product/create")
    public ResponseEntity<Product> save( @Valid @RequestBody ProductDto productDto)
    {
      return new ResponseEntity<>(productRepository.save(
              ProductMapper.INSTANCE.dtoToModel(productDto)), HttpStatus.CREATED);
      //kiran

    }

    @GetMapping("/getProducts")
    //@CrossOrigin(origins ="http://localhost:9910")
    public ResponseEntity<List<ProductDto>>findAll()
    {
        return new ResponseEntity<>(productMapper.modelsToDtos(productRepository.findAll()),HttpStatus.OK);

    }

    @GetMapping("/getProducts/{id}")

    public ProductDto findById(@PathVariable(value = "id")Integer id)
    {
        ProductDto productDto = (productMapper.modelToDto(productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Invalid Id : " +id))));
        return productDto;

    }

    @DeleteMapping("/deleteProducts/{id}")

    public ResponseEntity<ProductDto>deleteById(@PathVariable(value = "id")Integer id)
    {
        ProductDto productDto = (productMapper.modelToDto(productRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Invalid Id : " +id))));

        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/updateProducts")
    public ResponseEntity<Product> update( @Valid @RequestBody ProductDto productDto)
    {
        return new ResponseEntity<>(productRepository.save(
                ProductMapper.INSTANCE.dtoToModel(productDto)), HttpStatus.OK);

    }




}
