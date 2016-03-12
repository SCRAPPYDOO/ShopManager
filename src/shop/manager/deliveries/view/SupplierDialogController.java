package shop.manager.deliveries.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.manager.deliveries.model.Supplier;
import shop.manager.mapper.Mapper;
import shop.serwer.dao.facade.supplier.SupplierSearchCriteria;
import shop.serwer.service.SupplierService;
import shop.serwer.service.SupplierServiceImpl;

public class SupplierDialogController {
  @FXML
  private TextField supplierName;
  @FXML
  private TextField supplierNip;
  
  SupplierService supplierService = new SupplierServiceImpl();
  private DeliveryDialogController parent;
  private Stage dialogStage;
  private boolean okClicked = false;
  
  @FXML
  private TableView<Supplier> supplierTable;
  @FXML
  private TableColumn<Supplier, Integer> columnId;
  @FXML
  private TableColumn<Supplier, String> columnName;
  @FXML
  private TableColumn<Supplier, String> columnNip;
  
  public SupplierDialogController() {}
  
  @FXML
  private void initialize() {
    columnId.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
    columnName.setCellValueFactory(cellData -> cellData.getValue().getName());
    columnNip.setCellValueFactory(cellData -> cellData.getValue().getNip());

    supplierTable.setItems(Mapper.mapToSupplierList(supplierService.getListOfSupplier()));
  }
  
  @FXML
  private void onSearchAction() {
    SupplierSearchCriteria supplierSearchCriteria = new SupplierSearchCriteria();
    supplierSearchCriteria.setName(supplierName.getText());
    supplierSearchCriteria.setNip(supplierNip.getText());
   
    supplierTable.setItems(Mapper.mapToSupplierList(supplierService.getListOfItemsBySearchCriteria(supplierSearchCriteria)));  
  }
  
  @FXML
  private void onSelectAction() {
    Supplier supplier = supplierTable.getSelectionModel().getSelectedItem();
    parent.setCallbackResult(supplier);
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
