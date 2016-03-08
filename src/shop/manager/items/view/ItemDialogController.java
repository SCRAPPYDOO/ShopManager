package shop.manager.items.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.manager.deliveries.view.DeliveryDialogController;
import shop.manager.items.model.Item;
import shop.manager.mapper.Mapper;
import shop.serwer.dao.facade.item.ItemSearchCriteria;
import shop.serwer.service.ItemService;
import shop.serwer.service.ItemServiceImpl;

public class ItemDialogController {
  
  @FXML
  private TextField itemName;
  @FXML
  private TextField itemCode;
  
  @FXML
  private TableView<Item> itemTableList;
  @FXML
  private TableColumn<Item, String> name;
  @FXML
  private TableColumn<Item, String> code;
  
  private ItemService itemService;
  private Stage dialogStage;
  private boolean okClicked = false;
  private DeliveryDialogController parent;
  
  public ItemDialogController() {}
  
  @FXML
  private void initialize() {
    code.setCellValueFactory(cellData -> cellData.getValue().getCode());
    name.setCellValueFactory(cellData -> cellData.getValue().getName());
    
    itemService = new ItemServiceImpl();
    itemTableList.setItems(Mapper.mapToItemList(itemService.getListOfItems()));
  }

  @FXML
  private void onSearchAction() {
    ItemSearchCriteria itemSearchCriteria = new ItemSearchCriteria();
    itemSearchCriteria.setName(itemName.getText());
    itemSearchCriteria.setCode(itemCode.getText());
   
    itemTableList.setItems(Mapper.mapToItemList(itemService.getListOfItemsBySearchCriteria(itemSearchCriteria)));  
  }
  
  @FXML
  private void onSelectAction() {
    Item item = itemTableList.getSelectionModel().getSelectedItem();
    parent.setCallbackResult(item);
    dialogStage.close();
  }
  
  public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
  }
  
  public void setParent(DeliveryDialogController deliveryDialogController) {
    this.parent = deliveryDialogController;
  }
  
  public boolean isOkClicked() {
    return okClicked;
  }
}
