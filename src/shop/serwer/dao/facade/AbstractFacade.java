package shop.serwer.dao.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AbstractFacade<T> {

  private static Session session;
  
  {
    SessionFactory sessionFactory = new Configuration()
        .configure() // configures settings from hibernate.cfg.xml
        .buildSessionFactory();
    session = sessionFactory.openSession();
  }
  
  public T create(T entity) {
    session.beginTransaction();
    session.save(entity);
    session.getTransaction().commit();  
    return entity;
  }
  
  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    session.beginTransaction();
    List<T> result = session.createQuery("from Deliveries").list();
    session.getTransaction().commit();
    return result;
  }
}
