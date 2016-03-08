package shop.manager.deliveries.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shop.manager.MainApp;
import shop.manager.deliveries.model.Delivery;
import shop.manager.deliveries.model.DeliveryItem;
import shop.manager.items.model.Item;
import shop.manager.items.view.ItemDialogController;
import shop.manager.mapper.Mapper;

public class DeliveryDialogController { // extends AbstractPopup<Object> {

  @FXML
  private TextField deliveryId;
  @FXML
  private DatePicker deliveryDate;
  @FXML
  private TextField supplierName;
  @FXML
  private TextField documentName;
  @FXML
  private TextField deliveryExternalId;

  Item item;
  @FXML
  private TextField itemName;
  @FXML
  private TextField itemAmount;
  @FXML
  private TextField itemPrice;
  
  @FXML
  private TableView<DeliveryItem> deliveryItemTable;
  @FXML
  private TableColumn<DeliveryItem, Integer> id;
  @FXML
  private TableColumn<DeliveryItem, String> code;
  @FXML
  private TableColumn<DeliveryItem, String> name;
  @FXML
  private TableColumn<DeliveryItem, Integer> amount;
  @FXML
  private TableColumn<DeliveryItem, Double> price;
  
  private Delivery delivery;
  private Stage dialogStage;
  private boolean okClicked = false;

  public DeliveryDialogController() {}
  
  @FXML
  private void initialize() {
    id.setCellValueFactory(cellData -> { 
      if(cellData.getValue().getId() != null) {
        return cellData.getValue().getId().asObject();
      } else {
        return null;
      }
    });
    
    code.setCellValueFactory(cellData -> cellData.getValue().getItem().getCode());
    name.setCellValueFactory(cellData -> cellData.getValue().getItem().getName());
    amount.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
    price.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
    
    itemName.setEditable(false);
  }

  public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
  }

  public void setDelivery(Delivery delivery) {
    if(delivery != null) {
      this.delivery = delivery;
  
      deliveryId.setText(Integer.toString(delivery.getIdAsInt()));
      supplierName.setText(delivery.getSupplier().getNameAsString());
      documentName.setText(delivery.getDocument().getDocumentNameAsString());
      deliveryExternalId.setText(delivery.getExternalIdAsString());
      deliveryDate.setValue(delivery.getDeliveryDateAsLocalDate());

      this.deliveryItemTable.setItems(this.delivery.getItemList());
    }
  }

  public boolean isOkClicked() {
    return okClicked;
  }

  @FXML
  private void handleOk() {
    if (isInputValid()) {
      okClicked = true;
      dialogStage.close();
    }
  }

  @FXML
  private void handleCancel() {
    dialogStage.close();
  }
  
  private boolean isInputValid() {
    return true;
  }
  
  @FXML
  private boolean onSearchItemButton() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("items/view/ItemDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      dialogStage = new Stage();
      dialogStage.setTitle("Produkty");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(null);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);
      ItemDialogController controller = loader.getController();
      controller.setDialogStage(dialogStage);
      controller.setParent(this);
      
      dialogStage.showAndWait();

      return controller.isOkClicked();
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  @FXML
  private void onAddItemButton() {
    if(this.item != null && this.itemAmount.getText() != null && this.itemPrice != null) {
      DeliveryItem devitem = new DeliveryItem(Mapper.mapToIntegerProperty(this.itemAmount.getText()), Mapper.mapToDoubleProperty(this.itemPrice.getText()) , this.item);
      this.deliveryItemTable.getItems().add(devitem);
    
      this.item = null;
      this.itemName.setText(null);
      this.itemAmount.setText(null);
      this.itemAmount.setText(null);
    }
  }

  public void setCallbackResult(Item item) {
    this.item = item; 
    this.itemName.setText(item.getCodeNameString());
  }
}
