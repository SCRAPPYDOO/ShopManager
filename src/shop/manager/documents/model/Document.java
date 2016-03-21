package shop.manager.documents.model;

import javafx.beans.property.StringProperty;
import shop.manager.deliveries.model.Supplier;

public class Document {
  int id;
  
  StringProperty documentName;

  Supplier supplier;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public StringProperty getDocumentName() {
    return documentName;
  }

  public void setDocumentName(StringProperty documentName) {
    this.documentName = documentName;
  }

  public String getDocumentNameAsString() {
    return documentName.get();
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
  
  
}
