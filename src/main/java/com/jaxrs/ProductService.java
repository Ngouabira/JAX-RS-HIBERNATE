package com.jaxrs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProductService {


    private EntityManager em;
    private EntityManagerFactory emf;
    public ProductService() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public Product create(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        return product;
    }

    public List<Product> read() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    public Product find(int id) {
        return em.find(Product.class, id);
    }

    public Product update(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        return product;
    }


    public void delete(int id){
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        if(product != null){
            em.remove(product);
        }
        em.getTransaction().commit();
    }
}
