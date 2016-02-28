package shop.manager.deliveries.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shop.manager.documents.model.Document;

public class Delivery {
  private IntegerProperty id;
  private StringProperty externalId;
  private ObjectProperty<LocalDate> deliveryDate;
  private Supplier supplier;
  private ObservableList<DeliveryItem> itemList = FXCollections.observableArrayList();
  private Document document;

  public Delivery() {}

  public Delivery(IntegerProperty id, Supplier supplier, ObservableList<DeliveryItem> itemList) {
    super();
    this.id = id;
    this.supplier = supplier;
    this.itemList = itemList;
  }

  public IntegerProperty getId() {
    return id;
  }

  public int getIdAsInt() {
    return id.get();
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

  public ObservableList<DeliveryItem> getItemList() {
    return itemList;
  }

  public void setItemList(ObservableList<DeliveryItem> itemList) {
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
  }

  public StringProperty getExternalId() {
    return externalId;
  }

  public void setExternalId(StringProperty externalId) {
    this.externalId = externalId;
  }

  public String getExternalIdAsString() {
    return externalId.get();
  }

  public LocalDate getDeliveryDateAsLocalDate() {
    return deliveryDate.get();
  };
}
