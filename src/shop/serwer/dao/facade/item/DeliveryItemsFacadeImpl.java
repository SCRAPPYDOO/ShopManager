package shop.serwer.dao.facade.item;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.model.deliveries.DeliveryItemEntity;

public class DeliveryItemsFacadeImpl extends AbstractFacade<DeliveryItemEntity> implements DeliveryItemsFacade {

  public DeliveryItemsFacadeImpl() {
    super(DeliveryItemEntity.class);
  }
}
