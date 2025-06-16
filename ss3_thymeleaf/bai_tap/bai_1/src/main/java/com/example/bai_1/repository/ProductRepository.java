package com.example.bai_1.repository;

import com.example.bai_1.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;




@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
       List<Product> products = BaseRepository.getEntityManager().createQuery("SELECT p FROM Product AS p");
        return productList;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == updatedProduct.getId()) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        Product product = findById(id);
        if (product != null) {
            Transaction transaction = null;
            if (product != null) {
                try (Session session = sessionFactory.openSession()) {
                    transaction = session.beginTransaction();
                    session.remove(product);
                    transaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (transaction != null) {
                        transaction.rollback();
                    }
                }
            }
        }
    }
}
