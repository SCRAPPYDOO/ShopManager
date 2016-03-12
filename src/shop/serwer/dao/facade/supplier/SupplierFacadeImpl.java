package shop.serwer.dao.facade.supplier;

import java.util.List;

import javax.persistence.TypedQuery;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.model.deliveries.SupplierEntity;

public class SupplierFacadeImpl  extends AbstractFacade<SupplierEntity> implements SupplierFacade {

  public SupplierFacadeImpl() {
    super(SupplierEntity.class);
  }

  @Override
  public List<SupplierEntity> findAll() {
    TypedQuery<SupplierEntity> query = em.createNamedQuery(
        "findAllSuppliers", SupplierEntity.class);
    
    List<SupplierEntity> itemList = query.getResultList();
    return itemList;
  }

}
