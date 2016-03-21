package shop.serwer.service;

import java.util.List;

import javafx.collections.ObservableList;
import shop.manager.deliveries.model.Delivery;
import shop.manager.mapper.Mapper;
import shop.serwer.dao.facade.deliveries.DeliveriesFacade;
import shop.serwer.dao.facade.deliveries.DeliveriesFacadeImpl;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public class DeliveriesServiceImpl implements DeliveriesService {
  
  DeliveriesFacade facade = new DeliveriesFacadeImpl();
  
  @Override
  public ObservableList<Delivery> getListOfDeliveries() {
    
    List<DeliveryEntity> deliveryEntity = facade.findAll();
    return Mapper.mapToDeliveryList(deliveryEntity);
  }

  @Override
  public DeliveryEntity saveDevileryEntity(DeliveryEntity delivery) {
    return facade.create(delivery);
  }
}
