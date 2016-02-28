package shop.serwer.dao.facade.deliveries;

import java.util.List;

import javax.persistence.TypedQuery;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public class DeliveriesFacadeImpl extends AbstractFacade<DeliveryEntity> implements DeliveriesFacade{

  public DeliveriesFacadeImpl() {
    super(DeliveryEntity.class);
  }

  @Override
  public List<DeliveryEntity> findAll() {
    TypedQuery<DeliveryEntity> query = em.createNamedQuery(
        "findAll", DeliveryEntity.class);
    
    List<DeliveryEntity> deliveries = query.getResultList();
    return deliveries;
  }

}
