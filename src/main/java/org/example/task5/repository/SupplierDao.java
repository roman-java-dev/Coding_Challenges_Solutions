package org.example.task5.repository;

import org.example.task5.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierDao {
    List<Supplier> findAllSupplierWhoSupplyCondiments();

    void addNewCustomSupplierAndNewProduct();

    List<Supplier> getAll();

    Optional<Supplier> get(Long id);

    Supplier add(Supplier supplier);
}
