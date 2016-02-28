package shop.manager.deliveries.view;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shop.manager.MainApp;
import shop.manager.deliveries.model.Delivery;
import shop.serwer.service.DeliveriesService;
import shop.serwer.service.DeliveriesServiceImpl;

public class DeliveriesViewController {

  private Stage dialogStage;

  private DeliveriesService deliveriesService;

  @FXML
  private TableView<Delivery> deliveryTable;

  @FXML
  private TableColumn<Delivery, Integer> id;

  @FXML
  private TableColumn<Delivery, String> externalId;

  @FXML
  private TableColumn<Delivery, LocalDate> deliveryDate;

  @FXML
  private TableColumn<Delivery, String> supplier;

  @FXML
  private TableColumn<Delivery, String> documentId;

  public DeliveriesViewController() {}

  @FXML
  private void initialize() {
    id.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
    deliveryDate.setCellValueFactory(cellData -> cellData.getValue().getDeliveryDate());
    supplier.setCellValueFactory(cellData -> cellData.getValue().getSupplier().getName());
    documentId.setCellValueFactory(cellData -> cellData.getValue().getDocument().getDocumentName());
    externalId.setCellValueFactory(cellData -> cellData.getValue().getExternalId());

    this.initializeDeliveryDialog();

    deliveriesService = new DeliveriesServiceImpl();

    this.deliveryTable.setItems(deliveriesService.getListOfDeliveries());
  }

  private void initializeDeliveryDialog() {
    // TODO Auto-generated method stub
  }

  @FXML
  private boolean onDetailsButton() {
    Delivery delivery = getSelectedDelivery();

    if (delivery != null) {
      return showDeliveryPopUp(delivery);
    } else {
      Alert alert = new Alert(AlertType.WARNING);
      alert.initOwner(dialogStage);
      alert.setTitle("Brak zaznaczonej dostawy");
      alert.setHeaderText("Wybierz dostawę");
      alert.setContentText("Wybierz dostawę z tabeli");

      alert.showAndWait();

      return false;
    }
  }

  @FXML
  private boolean onNewDeliveryButton() {
    return showDeliveryPopUp(null);
  }

  private Delivery getSelectedDelivery() {
    return this.deliveryTable.getSelectionModel().getSelectedItem();
  }

  private boolean showDeliveryPopUp(Delivery delivery) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("deliveries/view/DeliveryDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      dialogStage = new Stage();
      dialogStage.setTitle("Dostawa");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(null);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);

      // Set the person into the controller.
      DeliveryDialogController controller = loader.getController();
      controller.setDialogStage(dialogStage);
      controller.setDelivery(delivery);

      dialogStage.showAndWait();

      return controller.isOkClicked();

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}

