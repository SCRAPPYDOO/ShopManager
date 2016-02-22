package shop.manager.model.delivery;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shop.manager.model.documents.Document;

public class Delivery {
  private IntegerProperty id;
  private Document document;
  private Contractor contractor;
  private ObjectProperty<LocalDate> deliveryDate;
  private ObservableList<ItemIn> listOfItems = FXCollections.observableArrayList();
  
  public Delivery() {
    
  }

  public IntegerProperty getId() {
    return id;
  }

  public Document getDocument() {
    return document;
  }

  public Contractor getContractor() {
    return contractor;
  }

  public ObjectProperty<LocalDate> getDeliveryDate() {
    return deliveryDate;
  }

  public void setId(IntegerProperty id) {
    this.id = id;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public void setContractor(Contractor contractor) {
    this.contractor = contractor;
  }

  public void setDeliveryDate(ObjectProperty<LocalDate> deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public ObservableList<ItemIn> getListOfItems() {
    return listOfItems;
  }

  public void setListOfItems(ObservableList<ItemIn> listOfItems) {
    this.listOfItems = listOfItems;
  }
}
