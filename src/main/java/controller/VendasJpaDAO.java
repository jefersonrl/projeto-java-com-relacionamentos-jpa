package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;
import model.Vendas;
 
public class VendasJpaDAO {
 
         private static VendasJpaDAO instance;
         protected EntityManager entityManager;
         
         public static VendasJpaDAO getInstance(){
                   if (instance == null){
                            instance = new VendasJpaDAO();
                   }
                   
                   return instance;
         }
 
         private VendasJpaDAO() {
                   entityManager = getEntityManager();
         }
 
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
 
                   return entityManager;
         }
 
         public Vendas getById(final int id) {
                   return entityManager.find(Vendas.class, id);
         }
 
         @SuppressWarnings("unchecked")
         public List<Cliente> findAll() {
                   return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
         }
 
         public void persist(Vendas vendas) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(vendas);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void merge(Vendas vendas) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(vendas);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void remove(Vendas vendas) {
                   try {
                            entityManager.getTransaction().begin();
                            vendas = entityManager.find(Vendas.class, vendas.getId_venda());
                            entityManager.remove(vendas);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void removeById(final int id) {
                   try {
                            Vendas vendas = getById(id);
                            remove(vendas);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
 
}