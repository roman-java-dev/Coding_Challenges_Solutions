package org.example.task5;

import org.example.task5.repository.CategoryDao;
import org.example.task5.repository.ProductDao;
import org.example.task5.repository.SupplierDao;
import org.example.task5.repository.impl.CategoryDaoImpl;
import org.example.task5.repository.impl.ProductDaoImpl;
import org.example.task5.repository.impl.SupplierDaoImpl;
import org.example.task5.service.CategoryService;
import org.example.task5.service.ProductService;
import org.example.task5.service.SupplierService;
import org.example.task5.service.impl.CategoryServiceImpl;
import org.example.task5.service.impl.ProductServiceImpl;
import org.example.task5.service.impl.SupplierServiceImpl;
import org.example.task5.util.DataInitializer;

public class Main {
    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        SupplierDao supplierDao = new SupplierDaoImpl(productDao);

        CategoryService categoryService = new CategoryServiceImpl(categoryDao);
        ProductService productService = new ProductServiceImpl(productDao);
        SupplierService supplierService = new SupplierServiceImpl(supplierDao);

        DataInitializer dataInitializer = new DataInitializer(supplierService,productService,categoryService);
        dataInitializer.initDB();

        productService.findProductWithNameBeginsWithC().forEach(System.out::println);
        System.out.println(productService.findProductWithSmallestPrice());
        productService.findPriceAllProductFromUSA().forEach(System.out::println);

        System.out.println(supplierService.findAllSupplierWhoSupplyCondiments());
        supplierService.addNewCustomSupplierAndNewProduct();
        supplierService.getAll().forEach(System.out::println);


    }
}
