package shop.manager.deliveries.view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import shop.manager.deliveries.model.Supplier;
import shop.manager.documents.model.Document;
import shop.manager.documents.view.DocumentsDialogController;
import shop.manager.items.model.Item;
import shop.manager.items.view.ItemDialogController;
import shop.manager.mapper.Mapper;
import shop.serwer.dao.model.deliveries.DeliveryEntity;
import shop.serwer.service.DeliveriesService;
import shop.serwer.service.DeliveriesServiceImpl;
import shop.serwer.service.DeliveryItemService;
import shop.serwer.service.DeliveryItemServiceImpl;

public class DeliveryDialogController { // extends AbstractPopup<Object> {

  @FXML
  private TextField deliveryId;
  @FXML
  private DatePicker deliveryDate;
  @FXML
  private TextField deliveryExternalId;

  //Wybor Itemu
  Item item;
  @FXML
  private TextField itemName;
  @FXML
  private TextField itemAmount;
  @FXML
  private TextField itemPrice;
  @FXML
  private Button addItemButton;
  
  //Wybor dostawcy
  Supplier supplier;
  @FXML
  private TextField supplierName;
  @FXML
  private Button searchSupplierButton;
   
  //Dokument
  Document document;
  @FXML
  private TextField documentName;
  @FXML
  private Button searchDocumentButton;
  
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
  
  @FXML
  private Button saveButton;
  @FXML
  private Button editButton;
  
  private Delivery delivery;
  private Stage dialogStage;
  private boolean okClicked = false;
  
  private DeliveriesService deliveryService = new DeliveriesServiceImpl();
  private DeliveryItemService deliveryItemService = new DeliveryItemServiceImpl();
  
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
    
    this.setControllsEnabled(true);
  }

  private void setControllsEnabled(boolean enabled) {
    this.deliveryId.setEditable(false);
    this.supplierName.setEditable(false);
    this.documentName.setEditable(false);
    
    this.deliveryDate.setEditable(enabled);
    this.deliveryExternalId.setEditable(enabled);
    
    //Items
    this.addItemButton.setDisable(!enabled);
    this.searchDocumentButton.setDisable(!enabled);
    this.searchSupplierButton.setDisable(!enabled);
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
      
      this.setControllsEnabled(false);
    }
  }

  public boolean isOkClicked() {
    return okClicked;
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
  private boolean onSearchSupplierButton() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("deliveries/view/SupplierDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      dialogStage = new Stage();
      dialogStage.setTitle("Dostawcy");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(null);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);
      SupplierDialogController controller = loader.getController();
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
  private boolean onSearchDocumentsButton() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("documents/view/DocumentsDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      dialogStage = new Stage();
      dialogStage.setTitle("Dokumenty");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(null);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);
      DocumentsDialogController controller = loader.getController();
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
      this.itemPrice.setText(null);
    }
  }

  public void setCallbackResult(Item item) {
    this.item = item; 
    this.item.setDelivery(this.delivery);
    this.itemName.setText(item.getCodeNameString());
  }

  public void setCallbackResult(Supplier supplier) {
    this.supplier = supplier;
    this.supplierName.setText(supplier.getNameAsString());
  }
  
  public void setCallbackResult(Document document) {
    this.document = document;
    this.documentName.setText(document.getDocumentNameAsString());
  }
  
  @FXML
  private void onSaveAction() {
    Delivery delivery = Mapper.mapToDelivery(deliveryService.saveDevileryEntity(Mapper.mapToDeliveryEntity(this.getDelivery())));
    
    ObservableList<DeliveryItem> items = this.deliveryItemTable.getItems();
    items.forEach((item) -> { item.setDelivery(delivery); });
    deliveryItemService.saveDeliveryItemsEntityList(Mapper.mapToListOfItemsEntity(items));
    dialogStage.close();
  }
  
  @FXML
  private void onEditAction() {
    this.setControllsEnabled(true);
  }
  
  private Delivery getDelivery() {
    Delivery temp = new Delivery();
    temp.setDocument(this.document);
    temp.setDeliveryDate(this.deliveryDate.valueProperty());
    temp.setExternalId(Mapper.mapToStringProperty(this.deliveryExternalId.getText()));
    temp.setId(Mapper.mapToIntegerProperty(this.deliveryId.promptTextProperty()));
    temp.setSupplier(this.supplier);
    return temp;
  }
}
