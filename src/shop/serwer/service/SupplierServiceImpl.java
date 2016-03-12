package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.facade.supplier.SupplierFacade;
import shop.serwer.dao.facade.supplier.SupplierFacadeImpl;
import shop.serwer.dao.facade.supplier.SupplierSearchCriteria;
import shop.serwer.dao.model.supplier.SupplierEntity;

public class SupplierServiceImpl implements SupplierService {

  SupplierFacade facade = new SupplierFacadeImpl();
  
  @Override
  public List<SupplierEntity> getListOfSupplier() {
    return facade.findAll();
  }

  @Override
  public List<SupplierEntity> getListOfItemsBySearchCriteria(
      SupplierSearchCriteria supplierSearchCriteria) {
    return facade.findAll();
  }

}
