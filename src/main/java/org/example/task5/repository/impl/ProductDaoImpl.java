package org.example.task5.repository.impl;

import org.example.task5.exception.DataProcessingException;
import org.example.task5.model.Product;
import org.example.task5.repository.ProductDao;
import org.example.task5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Optional<Product> findProductWithSmallestPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery(
                    "FROM Product p JOIN FETCH p.supplier s JOIN FETCH p.category c ORDER BY p.price ASC", Product.class);
            return query.setMaxResults(1).uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Can't find a product with the smallest price.", e);
        }
    }

    @Override
    public List<Product> findProductWithNameBeginsWithC() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery(
                    "FROM Product p JOIN FETCH p.supplier s "
                            + "JOIN FETCH p.category c WHERE p.productName LIKE 'C%'", Product.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Can't find a product with product_name that begins with ‘C’", e);
        }
    }

    @Override
    public List<BigDecimal> findPriceAllProductFromUSA() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<BigDecimal> query = session.createQuery(
                    "SELECT p.price FROM Product p WHERE p.supplier.country = 'USA'", BigDecimal.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Can't find cost of all products from the USA", e);
        }
    }

    @Override
    public Product add(Product product) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert "
                    + Product.class.getSimpleName() + " " + product, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
