package shop.serwer.dao.facade.documents;

import java.util.List;

import javax.persistence.TypedQuery;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.model.documents.DocumentEntity;

public class DocumentFacadeImpl extends AbstractFacade<DocumentEntity> implements DocumentFacade {

  public DocumentFacadeImpl() {
    super(DocumentEntity.class);
  }

  @Override
  public List<DocumentEntity> findBySearchCriteria(DocumentSearchCriteria documentSearchCriteria) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<DocumentEntity> findAll() {
    TypedQuery<DocumentEntity> query = em.createNamedQuery("findAllDocuments", DocumentEntity.class);

    List<DocumentEntity> documentList = query.getResultList();
    return documentList;
  }
}
