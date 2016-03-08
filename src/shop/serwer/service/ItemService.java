package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.item.ItemSearchCriteria;
import shop.serwer.dao.model.item.ItemEntity;

public interface ItemService {
  public List<ItemEntity> getListOfItemsBySearchCriteria(ItemSearchCriteria itemSearchCriteria);

  public List<ItemEntity> getListOfItems();
}
