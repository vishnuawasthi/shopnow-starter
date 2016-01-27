package com.shopnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopnow.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
