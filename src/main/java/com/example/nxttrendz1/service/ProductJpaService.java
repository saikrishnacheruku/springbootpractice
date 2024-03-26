/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

@Service
public class ProductJpaService implements ProductRepository {

  @Autowired
  private ProductJpaRepository productJpaRepository;

  @Override
  public List<Product> getProducts() {

    List<Product> productsList = productJpaRepository.findAll();

    return productsList;

  }

  @Override

  public Product getProductById(int productId) {
    try {
      Product product = productJpaRepository.findById(productId).get();
      return product;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Product addProduct(Product product) {
    return productJpaRepository.save(product);

  }

  @Override
  public Product updateProduct(int productId, Product product) {

    try {

      Product newProduct = productJpaRepository.findById(productId).get();

      if (product.getProductName() != null) {
        newProduct.setProductName(product.getProductName());
      }
      if (product.getPrice() != 0) {
        newProduct.setPrice(product.getPrice());
      }

      productJpaRepository.save(newProduct);

      return newProduct;
    } catch (Exception e) {

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void deleteProduct(int productId) {
    try {
      productJpaRepository.deleteById(productId);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
  }

}
