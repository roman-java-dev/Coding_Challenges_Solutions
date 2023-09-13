package org.example.task5.service;

import org.example.task5.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product findProductWithSmallestPrice();

    List<Product> findProductWithNameBeginsWithC();

    List<BigDecimal> findPriceAllProductFromUSA();

    Product add(Product product);
}
