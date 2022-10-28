package com.srinivasyalala.springbootsample.service;

import com.srinivasyalala.springbootsample.model.Product;

import java.util.List;
public interface IProductService
{
    List<Product> findAll();
    List<Product> findByID(long id);
}
