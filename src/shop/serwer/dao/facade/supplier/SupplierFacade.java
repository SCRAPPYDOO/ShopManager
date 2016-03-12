package shop.serwer.dao.facade.supplier;

import java.util.List;

import shop.serwer.dao.model.deliveries.SupplierEntity;

public interface SupplierFacade {

  List<SupplierEntity> findAll();
}
