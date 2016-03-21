package shop.serwer.dao.model.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "items")
@NamedQueries({
  @NamedQuery(name = "findAllItems",
      query = "FROM ItemEntity item")
  /*@NamedQuery(name = "findAllItemsBySearchCriteria",
  query = "FROM ItemEntity item WHERE item.code := code AND item.name := name")*/
})
public class ItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
