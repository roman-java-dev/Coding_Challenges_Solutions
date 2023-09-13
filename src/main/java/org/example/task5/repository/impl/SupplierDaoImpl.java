package org.example.task5.repository.impl;

import org.example.task5.exception.DataProcessingException;
import org.example.task5.model.Category;
import org.example.task5.model.Product;
import org.example.task5.model.Supplier;
import org.example.task5.repository.ProductDao;
import org.example.task5.repository.SupplierDao;
import org.example.task5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class SupplierDaoImpl implements SupplierDao {
    private final ProductDao productDao;

    public SupplierDaoImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Supplier> findAllSupplierWhoSupplyCondiments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Supplier> query = session.createQuery(
                    "SELECT s " +
                            "FROM Supplier s " +
                            "WHERE s.id IN (" +
                            "  SELECT DISTINCT p.supplier.id " +
                            "  FROM Product p " +
                            "  JOIN p.category c " +
                            "  WHERE c.categoryName = 'Condiments'" +
                            ")",
                    Supplier.class);

            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Can't find suppliers that supply Condiments", e);
        }
    }

    @Override
    public void addNewCustomSupplierAndNewProduct() {
        Supplier supplier = add(new Supplier("Norske Meierier","Lviv","Ukraine"));
        Category category = findNeedCategory("Beverages");
        productDao.add(new Product("Green tea", supplier, category, BigDecimal.valueOf(10)));
    }

    @Override
    public List<Supplier> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Supplier> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Supplier.class);
            criteriaQuery.from(Supplier.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can`t get all suppliers ", e);
        }
    }

    @Override
    public Optional<Supplier> get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Supplier.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get "
                    + Supplier.class.getSimpleName() + ", id: " + id, e);
        }
    }

    @Override
    public Supplier add(Supplier supplier) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(supplier);
            transaction.commit();
            return supplier;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert "
                    + Supplier.class.getSimpleName() + " " + supplier, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Category findNeedCategory(String categoryName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Category> query = session.createQuery(
                    "FROM Category c WHERE c.categoryName = :categoryName", Category.class);
            query.setParameter("categoryName", categoryName);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find category with name: " + categoryName, e);
        }
    }
}
