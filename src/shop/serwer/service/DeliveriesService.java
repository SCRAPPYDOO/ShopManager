package shop.serwer.service;

import javafx.collections.ObservableList;
import shop.manager.deliveries.model.Delivery;

public interface DeliveriesService {
  public ObservableList<Delivery> getListOfDeliveries();
}
