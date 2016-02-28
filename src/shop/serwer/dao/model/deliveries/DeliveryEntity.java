package shop.serwer.dao.model.deliveries;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import shop.serwer.dao.model.documents.DocumentEntity;


@Entity
public class DeliveryEntity {
  @Id
  int id;
  
  @Column(name = "external_id")
  String externalId;
  
  List<DeliveryItemEntity> listOfItems;
  
  SupplierEntity supplier;
  
  DocumentEntity document;
}
