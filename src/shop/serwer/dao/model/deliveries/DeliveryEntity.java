package shop.serwer.dao.model.deliveries;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import shop.serwer.dao.model.documents.DocumentEntity;


@Entity
@Table(name="deliveries")
public class DeliveryEntity {
  @Id
  private int id;
  
  @Column(name = "external_id")
  private String externalId;
  
  //List<DeliveryItemEntity> listOfItems;
  
  @OneToOne
  @JoinColumn(name="supplier_id", nullable=true)
  private SupplierEntity supplier;
  
  @OneToOne
  @JoinColumn(name="document_id", nullable=true)
  private DocumentEntity document;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public SupplierEntity getSupplier() {
    return supplier;
  }

  public void setSupplier(SupplierEntity supplier) {
    this.supplier = supplier;
  }

  public DocumentEntity getDocument() {
    return document;
  }

  public void setDocument(DocumentEntity document) {
    this.document = document;
  }
  
  
}

