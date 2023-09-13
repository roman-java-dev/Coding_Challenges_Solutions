package org.example.task5.util;

import org.example.task5.model.Category;
import org.example.task5.model.Product;
import org.example.task5.model.Supplier;
import org.example.task5.service.CategoryService;
import org.example.task5.service.ProductService;
import org.example.task5.service.SupplierService;

import java.math.BigDecimal;
import java.util.List;

public class DataInitializer {
    private static SupplierService supplierService;
    private static ProductService productService;
    private static CategoryService categoryService;

    public DataInitializer(SupplierService supplierService,
                           ProductService productService,
                           CategoryService categoryService) {
        DataInitializer.supplierService = supplierService;
        DataInitializer.productService = productService;
        DataInitializer.categoryService = categoryService;
    }

    public void initDB() {
        insertSupplierDataToDB().forEach(l -> supplierService.add(l));
        insertCategoryDataToDB().forEach(l -> categoryService.add(l));
        insertProductDataToDB().forEach(l -> productService.add(l));
    }

    private static List<Product> insertProductDataToDB() {
        return List.of(
                new Product(
                        1L, "Chais", supplierService.get(1L),
                        categoryService.get(1L), BigDecimal.valueOf(18.00)),
                new Product(
                        2L, "Chang", supplierService.get(1L),
                        categoryService.get(1L), BigDecimal.valueOf(19.00)),
                new Product(
                        3L, "Aniseed Syrup", supplierService.get(1L),
                        categoryService.get(2L), BigDecimal.valueOf(10.00)),
                new Product(
                        4L, "Chef Anton’s Cajun Seasoning", supplierService.get(2L),
                        categoryService.get(2L), BigDecimal.valueOf(22.00)),
                new Product(
                        5L, "Chef Anton’s Gumbo Mix", supplierService.get(2L),
                        categoryService.get(2L), BigDecimal.valueOf(21.35))
        );
    }

    private static List<Category> insertCategoryDataToDB() {
        return List.of(
        new Category(
                1L,"Beverages","Soft drinks, coffees, teas, beers, and ales"),
        new Category(
                2L,"Condiments","Sweet and savory sauces, relishes, spreads, "
                + "and seasonings"),
        new Category(
                3L,"Confections","Desserts, candies, and sweet breads"),
        new Category(4L,"Dairy Products","Cheeses"),
        new Category(
                5L,"Grains/Cereals","Breads, crackers, pasta, and cereal")
        );
    }

    private static List<Supplier> insertSupplierDataToDB() {
        return List.of(
        new Supplier(
                1L,"Exotic Liquid","London","UK"),
        new Supplier(
                2L,"New Orleans Cajun Delights","New Orleans","USA"),
        new Supplier(
                3L,"Grandma Kelly’s Homestead","Ann Arbor","USA"),
        new Supplier(
                4L,"Tokyo Traders","Tokyo","Japan"),
        new Supplier(
                5L,"Cooperativa de Quesos ‘Las Cabras’","Oviedo","Spain")
        );
    }
}
