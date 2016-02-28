package shop.manager.deliveries.view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.manager.deliveries.model.Delivery;

public class DeliveryDialogController {

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

  private Delivery delivery;
  private Stage dialogStage;
  private boolean okClicked = false;

  @FXML
  private void initialize() {

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
}
