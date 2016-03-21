package shop.serwer.service;

import javafx.collections.ObservableList;
import shop.manager.deliveries.model.Delivery;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public interface DeliveriesService {
  public ObservableList<Delivery> getListOfDeliveries();

  public DeliveryEntity saveDevileryEntity(DeliveryEntity mapToDeliveryEntity);
}
