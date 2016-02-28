package shop.serwer.dao.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractFacade<T> {

  private Class<T> entityClass;
  
  public AbstractFacade(Class<T> entityClass) {
    this.entityClass = entityClass;
  }
  
  private static EntityManager em;
  
  {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistentUnit");
    em = entityManagerFactory.createEntityManager();
  }
  
  public T create(T entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();  
    return entity;
  }
  
  public List<T> findAll() {
    em.getTransaction().begin();
    //List<T> result = em.find(entityClass, 1);
    em.getTransaction().commit();
    return null;
  }
  
  public T find(int id) {
    em.getTransaction().begin();
    T result = em.find(entityClass, id);
    em.getTransaction().commit();
    return result;
  }
}
