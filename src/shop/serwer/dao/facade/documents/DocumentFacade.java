package shop.serwer.dao.facade.documents;

import java.util.List;

import shop.serwer.dao.model.documents.DocumentEntity;

public interface DocumentFacade {

  List<DocumentEntity> findBySearchCriteria(DocumentSearchCriteria documentSearchCriteria);

  List<DocumentEntity> findAll();
}
