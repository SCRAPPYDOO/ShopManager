package shop.manager.deliveries.view;

import java.io.IOException;

import javafx.collections.ObservableList;
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
import shop.manager.items.view.ItemDialogController;
import shop.manager.util.Logger;

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
    id.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
    code.setCellValueFactory(cellData -> cellData.getValue().getItem().getCode());
    name.setCellValueFactory(cellData -> cellData.getValue().getItem().getName());
    amount.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
    price.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
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

      dialogStage.showAndWait();

      return controller.isOkClicked();
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
