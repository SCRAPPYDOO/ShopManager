package shop.serwer.dao.facade.item;

import java.util.List;

import shop.serwer.dao.model.deliveries.DeliveryItemEntity;

public interface DeliveryItemsFacade {

  List<DeliveryItemEntity> createSeveral(List<DeliveryItemEntity> listOfItemsEntity);
 
}
