package shop.manager.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import shop.manager.deliveries.model.Delivery;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public class MapperDefinition {

  private static MapperFactory factory;

  public MapperDefinition() {
    factory = new DefaultMapperFactory.Builder().build();

    factory.registerClassMap(factory.classMap(DeliveryEntity.class, Delivery.class)
        .byDefault().toClassMap());
  }

  public static MapperFacade getMapper() {
    if (factory == null) {
      factory = new DefaultMapperFactory.Builder().build();
    }
    return factory.getMapperFacade();
  }
}
