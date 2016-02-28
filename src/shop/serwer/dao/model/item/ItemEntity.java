package shop.serwer.dao.model.item;

import javax.persistence.Id;

public class ItemEntity {
  @Id
  int id;
  
  String name;
  
  int stockAmount;
}
