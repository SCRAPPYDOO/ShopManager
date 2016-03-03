package shop.manager.items.model;

import javafx.beans.property.StringProperty;

public class Item {
  int id;
  
  private StringProperty code;
  
  private StringProperty name;

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
  
  
}
