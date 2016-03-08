package shop.serwer.service;

import java.util.List;

import shop.serwer.dao.facade.item.ItemFacade;
import shop.serwer.dao.facade.item.ItemFacadeImpl;
import shop.serwer.dao.facade.item.ItemSearchCriteria;
import shop.serwer.dao.model.item.ItemEntity;

public class ItemServiceImpl implements ItemService {

  @Override
  public List<ItemEntity> getListOfItemsBySearchCriteria(ItemSearchCriteria itemSearchCriteria) {
    ItemFacade itemFacade = new ItemFacadeImpl();
    return itemFacade.findBySearchCriteria(itemSearchCriteria);
  }

  @Override
  public List<ItemEntity> getListOfItems() {
    ItemFacade itemFacade = new ItemFacadeImpl();
    return itemFacade.findAll();
  }

}
