package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.model.deliveries.DeliveryItemEntity;

public interface DeliveryItemService {

  public List<DeliveryItemEntity> saveDeliveryItemsEntityList(List<DeliveryItemEntity> mapToListOfItemsEntity);
}
