package com.srinivasyalala.springbootsample.controller;

import java.util.List;

import com.srinivasyalala.springbootsample.model.Product;
import com.srinivasyalala.springbootsample.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Boolean.TRUE;

@RestController
public class ProductController
{
    @Autowired
    private IProductService productService;
    //mapping the getProduct() method to /product
    @GetMapping(value = "/product")
    public List<Product> getProduct()
    {
        //finds all the products
        List<Product> products = productService.findAll();
        //returns the product list
        return products;
    }
    @GetMapping(value = "/productbyid/{id}")
    public List<Product> getProductbyID(@PathVariable long id)
    {
        //finds all the products
        List<Product> products = productService.findByID(id);
        //returns the product list
        return products;
        //return TRUE;
    }
}