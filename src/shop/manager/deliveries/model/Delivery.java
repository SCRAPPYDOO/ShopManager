package shop.manager.deliveries.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shop.manager.documents.model.Document;

public class Delivery {
  private IntegerProperty id;
  private ObjectProperty<LocalDate> deliveryDate;
  private Supplier supplier;
  private ObservableList<ItemIn> itemList = FXCollections.observableArrayList();
  private Document document;

  public Delivery() {}

  public Delivery(IntegerProperty id, Supplier supplier, ObservableList<ItemIn> itemList) {
    super();
    this.id = id;
    this.supplier = supplier;
    this.itemList = itemList;
  }

  public IntegerProperty getId() {
    return id;
  }

  public void setId(IntegerProperty id) {
    this.id = id;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public ObservableList<ItemIn> getItemList() {
    return itemList;
  }

  public void setItemList(ObservableList<ItemIn> itemList) {
    this.itemList = itemList;
  }

  public ObjectProperty<LocalDate> getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(ObjectProperty<LocalDate> deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  };
  
}
