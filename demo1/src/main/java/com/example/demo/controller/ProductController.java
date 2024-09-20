package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.request.ProductRequest;
import com.example.demo.service.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FileUpload fileUpload;

    @GetMapping("")
    public ResponseEntity<List<Product>> getListAllProduct(){
        return new ResponseEntity<>(productRepository.findAll(),HttpStatus.OK);
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@ModelAttribute ProductRequest productRequest) throws IOException {
        System.out.println(productRequest.toString());
        String imgUrl = fileUpload.uploadFile(productRequest.getImage());
        System.out.println(imgUrl);
        return new ResponseEntity<>(imgUrl, HttpStatus.OK);
    }

}
