package org.example.task5.service;

import org.example.task5.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAllSupplierWhoSupplyCondiments();

    void addNewCustomSupplierAndNewProduct();

    List<Supplier> getAll();

    Supplier get(Long id);

    Supplier add(Supplier supplier);
}
