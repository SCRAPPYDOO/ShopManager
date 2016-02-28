package shop.manager.deliveries.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

/*
 * delivery item
 */
public class DeliveryItem {
  private IntegerProperty id;
  private IntegerProperty amount;
  private DoubleProperty price;
  
  public DeliveryItem(IntegerProperty id, IntegerProperty amount, DoubleProperty price) {
    this.id = id;
    this.amount = amount;
    this.price = price;
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
}
