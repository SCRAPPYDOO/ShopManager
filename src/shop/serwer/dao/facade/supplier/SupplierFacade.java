package shop.serwer.dao.facade.supplier;

import java.util.List;

import shop.serwer.dao.model.supplier.SupplierEntity;

public interface SupplierFacade {

  List<SupplierEntity> findAll();
}
