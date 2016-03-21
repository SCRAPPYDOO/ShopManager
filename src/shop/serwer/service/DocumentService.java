package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.documents.DocumentSearchCriteria;
import shop.serwer.dao.model.documents.DocumentEntity;

public interface DocumentService {

  List<DocumentEntity> getListOfDocuments();

  List<DocumentEntity> getListOfItemsBySearchCriteria(
      DocumentSearchCriteria documentSearchCriteria);

}
