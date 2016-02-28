package shop.manager;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import shop.manager.deliveries.model.Delivery;
import shop.manager.deliveries.model.Supplier;
import shop.manager.deliveries.view.DeliveriesViewController;
import shop.manager.documents.model.Document;

public class MainApp extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  private ObservableList<Delivery> deliveryList;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Shop Manager");

    initRootLayout();

    // showMenuOverview();
    showDeliveriesView();
  }

  /**
   * Initializes the root layout.
   */
  public void initRootLayout() {
    try {
      // Load root layout from fxml file.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/main/MainView.fxml"));
      rootLayout = (BorderPane) loader.load();

      // Show the scene containing the root layout.
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Shows the person overview inside the root layout.
   */
  public void showDeliveriesView() {
    try {
      // Load person overview.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("deliveries/view/DeliveriesView.fxml"));
      AnchorPane deliveriesOverview = (AnchorPane) loader.load();

      rootLayout.setCenter(deliveriesOverview);

      // Give the controller access to the main app.
      DeliveriesViewController controller = loader.getController();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showMenuOverview() {
    try {
      // Load person overview.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/main/MenuView.fxml"));
      AnchorPane menuOverview = (AnchorPane) loader.load();

      // Set person overview into the center of root layout.
      rootLayout.setLeft(menuOverview);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns the main stage.
   * 
   * @return
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
