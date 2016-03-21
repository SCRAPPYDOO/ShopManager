package shop.serwer.dao.model.documents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import shop.serwer.dao.model.supplier.SupplierEntity;

@Entity
@Table(name="documents")
@NamedQueries({
  @NamedQuery(name = "findAllDocuments",
      query = "FROM DocumentEntity entity")
})
public class DocumentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
  
  @Column(name="document_name")
  String documentName;
  
  @OneToOne
  @JoinColumn(name="supplier_id", nullable=true)
  SupplierEntity supplier;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDocumentName() {
    return documentName;
  }

  public void setDocumentName(String documentName) {
    this.documentName = documentName;
  }

  public SupplierEntity getSupplier() {
    return supplier;
  }

  public void setSupplier(SupplierEntity supplier) {
    this.supplier = supplier;
  } 
}
