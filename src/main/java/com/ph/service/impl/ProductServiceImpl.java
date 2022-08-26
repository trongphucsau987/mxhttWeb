/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ph.service.impl;

import com.ph.pojo.Comment;
import com.ph.pojo.Product;
import com.ph.repository.ProductRepository;
import com.ph.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {
        return this.productRepository.getProducts(params, page);
    }

    @Override
    public int countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public boolean addProduct(Product p) {
        // xu ly update
        p.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg");
        
        return this.productRepository.addProduct(p);
    }

    @Override
    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }
    
    @Override
    public List<Object[]> countProdsByCate() {
        return this.productRepository.countProdsByCate();
    }

    @Override
    public List<Object[]> revenueStats(int quarter, int year) {
        return this.productRepository.revenueStats(quarter, year);
    }

    @Override
    public List<Comment> getComments(int productId) {
        return this.productRepository.getComments(productId);
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public Comment addComment(String content, int productId) {
        return this.productRepository.addComment(content, productId);
    }
}

