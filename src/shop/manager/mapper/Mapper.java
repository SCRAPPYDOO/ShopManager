package shop.manager.mapper;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shop.manager.deliveries.model.Delivery;
import shop.manager.deliveries.model.DeliveryItem;
import shop.manager.deliveries.model.Supplier;
import shop.manager.documents.model.Document;
import shop.manager.items.model.Item;
import shop.manager.util.Logger;
import shop.serwer.dao.model.deliveries.DeliveryEntity;
import shop.serwer.dao.model.deliveries.DeliveryItemEntity;
import shop.serwer.dao.model.deliveries.SupplierEntity;
import shop.serwer.dao.model.documents.DocumentEntity;
import shop.serwer.dao.model.item.ItemEntity;

public class Mapper {

  public static Delivery mapToDelivery(DeliveryEntity deliveryEntity) {
    Delivery delivery = new Delivery();
    delivery.setId(mapToIntegerProperty(deliveryEntity.getId()));
    delivery.setExternalId(mapToStringProperty(deliveryEntity.getExternalId()));
    delivery.setDocument(mapToDocument(deliveryEntity.getDocument()));
    delivery.setSupplier(mapToSupplier(deliveryEntity.getSupplier()));
    delivery.setItemList(mapToDeliveryItemList(deliveryEntity.getListOfItems()));
    delivery.setDeliveryDate(mapToDate(deliveryEntity.getDeliveryDate()));
    return delivery;
  }

  public static ObjectProperty<LocalDate> mapToDate(Date deliveryDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(deliveryDate);
    return new SimpleObjectProperty<LocalDate>(LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)));
  }

  public static ObservableList<DeliveryItem> mapToDeliveryItemList(
      List<DeliveryItemEntity> listOfItems) {
    Logger.log("lista itemow size " + listOfItems.size());
    ObservableList<DeliveryItem> list = FXCollections.observableArrayList();
    for(DeliveryItemEntity itemEntity : listOfItems) {  
      list.add(mapToDeliveryItem(itemEntity));
    }
    return list;
  }

  public static DeliveryItem mapToDeliveryItem(DeliveryItemEntity itemEntity) {
    DeliveryItem deliveryItem = new DeliveryItem(
        mapToIntegerProperty(itemEntity.getId()), 
        mapToIntegerProperty(itemEntity.getAmount()), 
        mapToDoubleProperty(itemEntity.getPrice()),
        mapToItem(itemEntity.getItem())
        );
  
    return deliveryItem;
  }

  private static Item mapToItem(ItemEntity itemEntity) {
    Item item = new Item();
    item.setId(itemEntity.getId());
    item.setCode(mapToStringProperty(itemEntity.getCode()));
    item.setName(mapToStringProperty(itemEntity.getName()));
    return item;
  }

  public static DoubleProperty mapToDoubleProperty(double doubleValue) {
    return new SimpleDoubleProperty(doubleValue);
  }

  public static Supplier mapToSupplier(SupplierEntity supplierEntity) {
    Supplier supplier = new Supplier();
    supplier.setId(mapToIntegerProperty(supplierEntity.getId()));
    supplier.setName(mapToStringProperty(supplierEntity.getName()));
    return supplier;
  }

  public static Document mapToDocument(DocumentEntity documentEntity) {
    Document document = new Document();
    document.setId(documentEntity.getId());
    document.setDocumentName(mapToStringProperty("maper fake name"));
    return document;
  }

  public static StringProperty mapToStringProperty(String string) {
    return new SimpleStringProperty(string);
  }

  public static IntegerProperty mapToIntegerProperty(Integer integer) {
    return new SimpleIntegerProperty(integer);
  }

  public static ObservableList<Delivery> mapToDeliveryList(List<DeliveryEntity> list) {
    ObservableList<Delivery> temp = FXCollections.observableArrayList();
    for(DeliveryEntity deliveryEntity : list) {
      temp.add(mapToDelivery(deliveryEntity));
    }
    
    return temp;
  }

  public static ObservableList<Item> mapToItemList(List<ItemEntity> listOfItems) {
    ObservableList<Item> temp = FXCollections.observableArrayList();
    for(ItemEntity itemEntity : listOfItems) {
      temp.add(mapToItem(itemEntity));
    }
    
    return temp;
  }

  public static IntegerProperty mapToIntegerProperty(String text) {
    return new SimpleIntegerProperty(Integer.parseInt(text));
  }

  public static DoubleProperty mapToDoubleProperty(String text) {
    return new SimpleDoubleProperty(Double.parseDouble(text));
  }
}
