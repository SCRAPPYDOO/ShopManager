package shop.serwer.dao.model.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemEntity {
  @Id
  int id;
  
  @Column(name = "name")
  String name;
  
  @Column(name = "code")
  String code;
  
  @Column(name = "stock_amount")
  int stockAmount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getStockAmount() {
    return stockAmount;
  }

  public void setStockAmount(int stockAmount) {
    this.stockAmount = stockAmount;
  }
}
