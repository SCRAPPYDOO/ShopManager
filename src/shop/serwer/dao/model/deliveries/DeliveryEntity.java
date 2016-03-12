package shop.serwer.dao.model.deliveries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import shop.serwer.dao.model.documents.DocumentEntity;
import shop.serwer.dao.model.supplier.SupplierEntity;

@Entity
@Table(name="deliveries")
@NamedQueries({
  @NamedQuery(name = "findAll",
      query = "FROM DeliveryEntity entity")
})
public class DeliveryEntity {
  @Id
  private Integer id;
  
  @Column(name = "external_id")
  private String externalId;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "delivery")
  private List<DeliveryItemEntity> listOfItems;
  
  @OneToOne
  @JoinColumn(name="supplier_id", nullable=true)
  private SupplierEntity supplier;
  
  @OneToOne
  @JoinColumn(name="document_id", nullable=true)
  private DocumentEntity document;

  @Column(name = "delivery_date")
  Date deliveryDate;
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public List<DeliveryItemEntity> getListOfItems() {
    if(this.listOfItems == null) {
      this.listOfItems = new ArrayList<DeliveryItemEntity>();
    }
    return listOfItems;
  }

  public void setListOfItems(List<DeliveryItemEntity> listOfItems) {
    this.listOfItems = listOfItems;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
}

