package shop.manager.items.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ItemDialogController {
  
  private Stage dialogStage;
  private boolean okClicked = false;
  
  public ItemDialogController() {}
  
  @FXML
  private void initialize() {

  }

  public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
  }
  
  public boolean isOkClicked() {
    return okClicked;
  }
}
