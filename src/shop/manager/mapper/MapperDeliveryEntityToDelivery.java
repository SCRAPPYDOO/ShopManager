package shop.manager.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import shop.manager.deliveries.model.Delivery;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public class MapperDeliveryEntityToDelivery extends CustomMapper<DeliveryEntity, Delivery>{
  
  @Override
  public void mapAtoB(DeliveryEntity deliveryEntity, Delivery delivery, MappingContext context) {
    //delivery.setId(new SimpleIntegerProperty(deliveryEntity.getId()));
    //delivery.setExternalId(new SimpleStringProperty(deliveryEntity.getExternalId()));
  }

}
