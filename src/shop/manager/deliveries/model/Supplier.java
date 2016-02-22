package shop.manager.deliveries.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Supplier {
  private IntegerProperty id;
  private StringProperty lastName;
  
  public Supplier(IntegerProperty id, StringProperty lastName) {
    super();
    this.id = id;
    this.lastName = lastName;
  }
  
  public IntegerProperty getId() {
    return id;
  }
  
  public void setId(IntegerProperty id) {
    this.id = id;
  }
  
  public StringProperty getLastName() {
    return lastName;
  }
  
  public void setLastName(StringProperty lastName) {
    this.lastName = lastName;
  }
}
