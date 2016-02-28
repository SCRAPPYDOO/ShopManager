package shop.serwer.dao.facade.deliveries;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public class DeliveriesFacadeImpl extends AbstractFacade<DeliveryEntity> implements DeliveriesFacade{

  public DeliveriesFacadeImpl() {
    super(DeliveryEntity.class);
  }

}
