package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.supplier.SupplierSearchCriteria;
import shop.serwer.dao.model.supplier.SupplierEntity;

public interface SupplierService {

  List<SupplierEntity> getListOfSupplier();

  List<SupplierEntity> getListOfItemsBySearchCriteria(SupplierSearchCriteria supplierSearchCriteria);

}
