/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ph.controllers;

import com.ph.pojo.Comment;
import com.ph.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("/products/{productId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "productId") int id) {
        
        return new ResponseEntity<>(this.productService.getComments(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "/products/{productId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        String content = params.get("content");
        int productId = Integer.parseInt(params.get("productId"));
        
        Comment c = this.productService.addComment(content, productId);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}