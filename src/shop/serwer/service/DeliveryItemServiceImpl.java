package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.item.DeliveryItemsFacade;
import shop.serwer.dao.facade.item.DeliveryItemsFacadeImpl;
import shop.serwer.dao.model.deliveries.DeliveryItemEntity;

public class DeliveryItemServiceImpl implements DeliveryItemService {

  private DeliveryItemsFacade deliveryItemsFacade = new DeliveryItemsFacadeImpl();
  
  @Override
  public List<DeliveryItemEntity> saveDeliveryItemsEntityList(List<DeliveryItemEntity> listOfItemsEntity) {
    return deliveryItemsFacade.createSeveral(listOfItemsEntity);
  }
}
