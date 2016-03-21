package shop.manager.items.model;

import javafx.beans.property.StringProperty;
import shop.manager.deliveries.model.Delivery;

public class Item {
  int id;
  
  private StringProperty code;
  
  private StringProperty name;

  Delivery delivery;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public StringProperty getCode() {
    return code;
  }

  public void setCode(StringProperty code) {
    this.code = code;
  }

  public StringProperty getName() {
    return name;
  }

  public void setName(StringProperty name) {
    this.name = name;
  }
  
  public String getCodeNameString() {
    return this.code.get() + " " + this.name.get();
  }

  public Delivery getDelivery() {
    return delivery;
  }

  public void setDelivery(Delivery delivery) {
    this.delivery = delivery;
  }
}
