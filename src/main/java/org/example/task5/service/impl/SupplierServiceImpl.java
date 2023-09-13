package org.example.task5.service.impl;

import org.example.task5.model.Supplier;
import org.example.task5.repository.SupplierDao;
import org.example.task5.service.SupplierService;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private final SupplierDao supplierDao;

    public SupplierServiceImpl(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public List<Supplier> findAllSupplierWhoSupplyCondiments() {
        return supplierDao.findAllSupplierWhoSupplyCondiments();
    }

    @Override
    public void addNewCustomSupplierAndNewProduct() {
        supplierDao.addNewCustomSupplierAndNewProduct();
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }

    @Override
    public Supplier get(Long id) {
        return supplierDao.get(id).orElseThrow(
                () -> new RuntimeException("Supplier with id " + id + " not found")
        );
    }

    @Override
    public Supplier add(Supplier supplier) {
        return supplierDao.add(supplier);
    }
}
