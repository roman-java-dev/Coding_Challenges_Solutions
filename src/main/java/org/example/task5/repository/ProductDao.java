package org.example.task5.repository;

import org.example.task5.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Optional<Product> findProductWithSmallestPrice();

    List<Product> findProductWithNameBeginsWithC();

    List<BigDecimal> findPriceAllProductFromUSA();

    Product add(Product product);
}
