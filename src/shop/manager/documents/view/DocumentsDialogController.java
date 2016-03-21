package shop.manager.documents.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.manager.deliveries.view.DeliveryDialogController;
import shop.manager.documents.model.Document;
import shop.manager.mapper.Mapper;
import shop.serwer.dao.facade.documents.DocumentSearchCriteria;
import shop.serwer.service.DocumentService;
import shop.serwer.service.DocumentServiceImpl;

public class DocumentsDialogController {
  
  @FXML
  private TextField documentName;
  @FXML
  private TextField supplierName;
  
  DocumentService documentService = new DocumentServiceImpl();
  private DeliveryDialogController parent;
  private Stage dialogStage;
  private boolean okClicked = false;
  
  @FXML
  private TableView<Document> documentsTable;
  @FXML
  private TableColumn<Document, String> columnNumber;
  @FXML
  private TableColumn<Document, String> columnSupplierName;
  
  public DocumentsDialogController() {}
  
  @FXML
  private void initialize() {
    columnNumber.setCellValueFactory(cellData -> cellData.getValue().getDocumentName());
    columnSupplierName.setCellValueFactory(cellData -> cellData.getValue().getSupplier().getName());

    documentsTable.setItems(Mapper.mapToDocumentsList(documentService.getListOfDocuments()));
  }
  
  @FXML
  private void onSearchAction() {
    DocumentSearchCriteria documentSearchCriteria = new DocumentSearchCriteria();
    documentSearchCriteria.setDocumentName(documentName.getText());
    documentSearchCriteria.setSupplierName(supplierName.getText());
   
    documentsTable.setItems(Mapper.mapToDocumentsList(documentService.getListOfItemsBySearchCriteria(documentSearchCriteria)));  
  }
  
  @FXML
  private void onSelectAction() {
    Document document = documentsTable.getSelectionModel().getSelectedItem();
    parent.setCallbackResult(document);
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
