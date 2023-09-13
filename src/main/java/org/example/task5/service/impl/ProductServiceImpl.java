package org.example.task5.service.impl;

import org.example.task5.model.Product;
import org.example.task5.repository.ProductDao;
import org.example.task5.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product findProductWithSmallestPrice() {
        return productDao.findProductWithSmallestPrice().orElseThrow(
                () -> new RuntimeException("Product with the lowest price could not be found")
        );
    }

    @Override
    public List<Product> findProductWithNameBeginsWithC() {
        return productDao.findProductWithNameBeginsWithC();
    }

    @Override
    public List<BigDecimal> findPriceAllProductFromUSA() {
        return productDao.findPriceAllProductFromUSA();
    }

    @Override
    public Product add(Product product) {
        return productDao.add(product);
    }
}
