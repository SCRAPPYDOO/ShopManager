package shop.serwer.dao.model.deliveries;

import javax.persistence.Id;

import shop.serwer.dao.model.item.ItemEntity;

public class DeliveryItemEntity {
  @Id
  int id;
  
  ItemEntity item;
  
  int amount;
  
  double price;
}
