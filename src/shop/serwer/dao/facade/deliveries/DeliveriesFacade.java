package shop.serwer.dao.facade.deliveries;

import java.util.List;

import shop.serwer.dao.model.deliveries.DeliveryEntity;

public interface DeliveriesFacade {
  
  public DeliveryEntity create(DeliveryEntity deliveryEntity);

  public List<DeliveryEntity> findAll();

  public DeliveryEntity find(int id);
}
