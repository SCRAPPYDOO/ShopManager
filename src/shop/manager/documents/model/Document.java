package shop.manager.documents.model;

import javafx.beans.property.StringProperty;

public class Document {
  int id;
  
  StringProperty documentName;

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
}
