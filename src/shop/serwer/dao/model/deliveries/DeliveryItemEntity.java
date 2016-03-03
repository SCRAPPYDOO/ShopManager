package shop.serwer.dao.model.deliveries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import shop.serwer.dao.model.item.ItemEntity;

@Entity
@Table(name="delivery_items")
public class DeliveryItemEntity {
  @Id
  @Column(name = "id")
  private int id;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  ItemEntity item;
  
  @Column(name = "amount")
  private int amount;
  
  @Column(name = "price")
  private double price;
   
  @OneToOne
  @JoinColumn(name="delivery_id", nullable=false)
  private DeliveryEntity delivery;

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

  public ItemEntity getItem() {
    return item;
  }

  public void setItem(ItemEntity item) {
    this.item = item;
  }

  public DeliveryEntity getDelivery() {
    return delivery;
  }

  public void setDelivery(DeliveryEntity delivery) {
    this.delivery = delivery;
  }
}

