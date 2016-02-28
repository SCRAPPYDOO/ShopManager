package shop.serwer.dao.model.deliveries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import shop.serwer.dao.model.item.ItemEntity;

@Entity
@Table(name="delivery_items")
public class DeliveryItemEntity {
  @Id
  int id;
  
  //ItemEntity item;
  
  //int amount;
  
  //double price;
}
