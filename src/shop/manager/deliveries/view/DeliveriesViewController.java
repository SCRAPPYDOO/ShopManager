package shop.manager.deliveries.view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ma.glasnost.orika.Mapper;
import shop.manager.MainApp;
import shop.manager.deliveries.model.Delivery;
import shop.manager.mapper.MapperDefinition;
import shop.serwer.dao.facade.deliveries.DeliveriesFacade;
import shop.serwer.dao.facade.deliveries.DeliveriesFacadeImpl;
import shop.serwer.dao.model.deliveries.DeliveryEntity;

public class DeliveriesViewController {

  private Stage dialogStage;
  
  @FXML
  private TableView<Delivery> deliveryTable;

  @FXML
  private TableColumn<Delivery, Integer> id;

  @FXML
  private TableColumn<Delivery, LocalDate> deliveryDate;

  @FXML
  private TableColumn<Delivery, String> supplier;

  @FXML
  private TableColumn<Delivery, String> documentId;

  public DeliveriesViewController() {

  }

  public void setDevlieriesList(ObservableList<Delivery> deliveryList) {
    deliveryTable.setItems(deliveryList);
  }

  @FXML
  private void initialize() {
    id.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
    deliveryDate.setCellValueFactory(cellData -> cellData.getValue().getDeliveryDate());
    supplier.setCellValueFactory(cellData -> cellData.getValue().getSupplier().getName());
    documentId.setCellValueFactory(cellData -> cellData.getValue().getDocument().getDocumentName());

    this.initializeDeliveryDialog();

    this.addListeners();
    
    DeliveriesFacade facade = new DeliveriesFacadeImpl();
    DeliveryEntity deliveryEntity = facade.find(1);
    
    
    ObservableList<Delivery> deliveryList = FXCollections.observableArrayList();
    deliveryList.add(MapperDefinition.getMapper().map(deliveryEntity, Delivery.class));
    this.setDevlieriesList(deliveryList);
  }

  private void initializeDeliveryDialog() {
    // TODO Auto-generated method stub

  }

  private void addListeners() {
    // deliveryTable.add

  }

  @FXML
  private void onDetailsButton() {
    // int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
    // personTable.getItems().remove(selectedIndex);
  }

  @FXML
  private boolean onNewDeliveryButton() {
    try {
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("deliveries/view/DeliveryDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      dialogStage = new Stage();
      dialogStage.setTitle("Edit Person");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(null);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);

      // Set the person into the controller.
      DeliveryDialogController controller = loader.getController();
      controller.setDialogStage(dialogStage);
      // controller.setPerson(person);

      // Show the dialog and wait until the user closes it
      dialogStage.showAndWait();

      return controller.isOkClicked();
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
