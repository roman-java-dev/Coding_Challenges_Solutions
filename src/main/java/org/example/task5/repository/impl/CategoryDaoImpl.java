package org.example.task5.repository.impl;

import org.example.task5.exception.DataProcessingException;
import org.example.task5.model.Category;
import org.example.task5.repository.CategoryDao;

import java.util.Optional;
import org.example.task5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CategoryDaoImpl implements CategoryDao {

    @Override
    public Optional<Category> get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Category.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get "
                    + Category.class.getSimpleName() + ", id: " + id, e);
        }
    }

    @Override
    public Category add(Category category) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return category;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert "
                    + Category.class.getSimpleName() + " " + category, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
