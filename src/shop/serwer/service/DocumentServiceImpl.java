package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.documents.DocumentFacade;
import shop.serwer.dao.facade.documents.DocumentFacadeImpl;
import shop.serwer.dao.facade.documents.DocumentSearchCriteria;
import shop.serwer.dao.model.documents.DocumentEntity;

public class DocumentServiceImpl implements DocumentService {

  DocumentFacade documentFacade = new DocumentFacadeImpl();
  
  @Override
  public List<DocumentEntity> getListOfDocuments() {
    return documentFacade.findAll();
  }

  @Override
  public List<DocumentEntity> getListOfItemsBySearchCriteria(
      DocumentSearchCriteria documentSearchCriteria) {
    return documentFacade.findBySearchCriteria(documentSearchCriteria);
  }
}
