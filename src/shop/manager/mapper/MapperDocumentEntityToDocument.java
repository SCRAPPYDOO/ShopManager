package shop.manager.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import shop.manager.documents.model.Document;
import shop.serwer.dao.model.documents.DocumentEntity;

public class MapperDocumentEntityToDocument extends CustomMapper<DocumentEntity, Document>{
  
  @Override
  public void mapAtoB(DocumentEntity documentEntity, Document document, MappingContext context) {
    //document.setId(new SimpleIntegerProperty(documentEntity.getId()));
  }
}
