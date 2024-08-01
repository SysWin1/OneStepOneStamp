package org.example.onesteponestamp.javafx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class AdminMainController {

  @FXML
  private BorderPane mainLayOut;

  @FXML
  private HBox menu;

  @FXML
  private Button autoApplyButton;

  @FXML
  private Button immigrationButton;

  @FXML
  private Button foreignerButton;

  @FXML
  private Button homeButton;

  @FXML
  private ImageView homeIcon;

  @FXML
  private Region space;

  @FXML
  private VBox centerContent;

  @FXML
  private void initialize() {
    autoApplyButton.setOnAction(e -> {
      try {
        showAutoApplyList();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    immigrationButton.setOnAction(e -> showImmigrationList());
    foreignerButton.setOnAction(e -> showForeignerList());
    homeButton.setOnAction(e -> {
      try {
        showHome();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    Image homeImage = new Image(
        getClass().getResourceAsStream("/org/example/onesteponestamp/images/home.png"));
    homeIcon.setImage(homeImage);
  }

  private void resetButtonStyles() {
    autoApplyButton.setStyle("");
    immigrationButton.setStyle("");
    foreignerButton.setStyle("");
  }

  private void showAutoApplyList() throws IOException {
    resetButtonStyles();
    autoApplyButton.setStyle("-fx-background-color: #9B4444;");
//
//    AutoApplyAdminView view = new AutoApplyAdminView();
//    new AutoApplyAdminController(view);
//    mainLayOut.setCenter(view.getMainGrid());
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/org/example/onesteponestamp/javafx/autoApplyAdmin.fxml"));
    BorderPane adminAutoApply = loader.load();
    mainLayOut.setCenter(adminAutoApply);
  }

  private void showImmigrationList() {
    resetButtonStyles();
    immigrationButton.setStyle("-fx-background-color: #9B4444;");
    ImmigrationListForm immigrationForm = new ImmigrationListForm();
    mainLayOut.setCenter(immigrationForm.getForm());
  }

  private void showForeignerList() {
    resetButtonStyles();
    foreignerButton.setStyle("-fx-background-color: #9B4444;");
    ForeignerForm foreignerForm = new ForeignerForm();
    mainLayOut.setCenter(foreignerForm.getForm());
  }

  private void showHome() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/org/example/onesteponestamp/fxml/UserMainView.fxml"));
    BorderPane mainView = loader.load();
    // 현재 씬의 루트 노드를 mainView로 변경합니다.
    mainLayOut.getScene().setRoot(mainView);
  }
}
