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
  
  int amount;
  
  double price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
