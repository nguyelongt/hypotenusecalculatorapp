package app.hypotenusecalculator.ui;

import app.hypotenusecalculator.business.Validation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class HypotenuseCalculatorApp extends Application {

    private TextField sideATextBox;
    private TextField sideBTextBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane grid = new GridPane();
        primaryStage.setTitle("Hypotenuse Calculator");
        primaryStage.setScene(new Scene(grid, 300, 200));
        primaryStage.show();
        // Padding
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        // Label
        Label sideALabel = new Label("Side A");
        Label sideBLabel = new Label("Side B");
        Label sideCLabel = new Label("Side C");
        // Text Box
        sideATextBox = new TextField();
        sideBTextBox = new TextField();
        TextField sideCTextBox = new TextField();
        // Button
        Button calculateButton = new Button("Calculate");
        Button exitButton = new Button("Exit");
        // Button Box
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        // Grid Label
        grid.add(sideALabel, 0, 0);
        grid.add(sideBLabel, 0, 1);
        grid.add(sideCLabel, 0, 2);
        // Grid Text Box
        grid.add(sideATextBox, 1, 0);
        grid.add(sideBTextBox, 1, 1);
        grid.add(sideCTextBox, 1, 2);
        sideCTextBox.setEditable(false);
        // Grid Button
        grid.add(buttonBox, 0, 4, 2, 1);
        // Event Listener
        calculateButton.setOnAction(event -> calculateButtonClicked());
        exitButton.setOnAction(event -> exitButtonClicked());

    }

    private void calculateButtonClicked() {
        // New instance of Validation
        Validation v = new Validation();
        // Error message
        String errorMessage = "";
        errorMessage += v.isInteger(sideATextBox.getText(), "Side A");
        errorMessage += v.isInteger(sideBTextBox.getText(), "Side B");

        if (errorMessage.isEmpty()) {
            int sideA = Integer.parseInt(sideATextBox.getText());
            int sideB = Integer.parseInt(sideBTextBox.getText());
        } else {
            // Create Alert Message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Data");
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
    }

    private void exitButtonClicked() {
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
