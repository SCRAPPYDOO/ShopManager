package shop.manager.deliveries.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import shop.manager.items.model.Item;

public class DeliveryItem {
  private IntegerProperty id;
  private IntegerProperty amount;
  private DoubleProperty price;
  private Item item;
  private Delivery delivery;
  
  public DeliveryItem(IntegerProperty amount, DoubleProperty price, Item item) {
    this.amount = amount;
    this.price = price;
    this.item = item;
  }
  
  public DeliveryItem(IntegerProperty id, IntegerProperty amount, DoubleProperty price, Item item) {
    this.id = id;
    this.amount = amount;
    this.price = price;
    this.item = item;
  }

  public IntegerProperty getId() {
    return id;
  }

  public void setId(IntegerProperty id) {
    this.id = id;
  }

  public IntegerProperty getAmount() {
    return amount;
  }

  public void setAmount(IntegerProperty amount) {
    this.amount = amount;
  }

  public DoubleProperty getPrice() {
    return price;
  }

  public void setPrice(DoubleProperty price) {
    this.price = price;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Delivery getDelivery() {
    return delivery;
  }

  public void setDelivery(Delivery delivery) {
    this.delivery = delivery;
  }
}
