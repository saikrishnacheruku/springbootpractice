/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here

package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.*;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
