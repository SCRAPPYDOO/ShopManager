package shop.manager.deliveries.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Supplier {
  private IntegerProperty id;
  private StringProperty name;
  private StringProperty nip;
  
  public Supplier() {}

  public IntegerProperty getId() {
    return id;
  }
  
  public void setId(IntegerProperty id) {
    this.id = id;
  }
  
  public StringProperty getName() {
    return name;
  }
  
  public void setName(StringProperty name) {
    this.name = name;
  }

  public String getNameAsString() {
    return name.get();
  }

  public StringProperty getNip() {
    return nip;
  }

  public void setNip(StringProperty nip) {
    this.nip = nip;
  }
  
}
