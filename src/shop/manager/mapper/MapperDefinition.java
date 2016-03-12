package shop.manager.mapper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import shop.manager.deliveries.model.Delivery;
import shop.manager.deliveries.model.DeliveryItem;
import shop.manager.deliveries.model.Supplier;
import shop.manager.documents.model.Document;
import shop.serwer.dao.model.deliveries.DeliveryEntity;
import shop.serwer.dao.model.deliveries.DeliveryItemEntity;
import shop.serwer.dao.model.documents.DocumentEntity;
import shop.serwer.dao.model.supplier.SupplierEntity;

public class MapperDefinition {

  private static MapperFactory factory;

  static  {
    factory = new DefaultMapperFactory.Builder().build();
    
    factory.registerClassMap(factory.classMap(DeliveryEntity.class, Delivery.class)
        .customize(new MapperDeliveryEntityToDelivery())
        .byDefault().toClassMap());
    
    factory.registerClassMap(factory.classMap(SupplierEntity.class, Supplier.class)
        .customize(new MapperSupplierEntityToSupplier())
        .byDefault().toClassMap());
    
    factory.registerClassMap(factory.classMap(DocumentEntity.class, Document.class)
        .customize(new MapperDocumentEntityToDocument())
        .byDefault().toClassMap());
    
    factory.registerClassMap(factory.classMap(DeliveryItemEntity.class, DeliveryItem.class)
        .customize(new MapperDeliveryItemEntityToDeliveryItem())
        .byDefault().toClassMap());
    
    factory.registerClassMap(factory.classMap(String.class, StringProperty.class)
        .customize(new MapperStringToSimpleStringProperty())
        .byDefault().toClassMap());
    
    factory.registerClassMap(factory.classMap(Integer.class, IntegerProperty.class)
        .customize(new MapperIntegerToIntegerProperty())
        .byDefault().toClassMap());
  }

  public static MapperFacade getMapper() {
    return factory.getMapperFacade();
  }
}
