package shop.serwer.dao.facade.item;

import java.util.List;

import shop.serwer.dao.model.item.ItemEntity;

public interface ItemFacade {
  public ItemEntity create(ItemEntity itemEntity);

  public List<ItemEntity> findAll();

  public ItemEntity find(int id);
  
  public List<ItemEntity> findBySearchCriteria(ItemSearchCriteria itemSearchCriteria);
}
