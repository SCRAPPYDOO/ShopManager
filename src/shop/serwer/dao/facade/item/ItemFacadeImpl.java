package shop.serwer.dao.facade.item;

import java.util.List;

import javax.persistence.TypedQuery;

import shop.serwer.dao.facade.AbstractFacade;
import shop.serwer.dao.model.item.ItemEntity;

public class ItemFacadeImpl extends AbstractFacade<ItemEntity> implements ItemFacade{

  public ItemFacadeImpl() {
    super(ItemEntity.class);
  }

  @Override
  public List<ItemEntity> findAll() {
    TypedQuery<ItemEntity> query = em.createNamedQuery(
        "findAllItems", ItemEntity.class);
    
    List<ItemEntity> itemList = query.getResultList();
    return itemList;
  }

  @Override
  public List<ItemEntity> findBySearchCriteria(ItemSearchCriteria itemSearchCriteria) {
    // TODO Auto-generated method stub
    return null;
  }
}
