package shop.manager.mapper;

import javafx.beans.property.SimpleIntegerProperty;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import shop.manager.deliveries.model.Supplier;
import shop.serwer.dao.model.supplier.SupplierEntity;

public class MapperSupplierEntityToSupplier extends CustomMapper<SupplierEntity, Supplier>{
  
  @Override
  public void mapAtoB(SupplierEntity supplierEntity, Supplier supplier, MappingContext context) {
    supplier.setId(new SimpleIntegerProperty(supplierEntity.getId()));
  }
}
