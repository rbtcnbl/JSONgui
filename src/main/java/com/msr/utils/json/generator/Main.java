package com.msr.utils.json.generator;


import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

//    @Override
//    public void start(Stage primaryStage) {
//        try {
//            AnchorPane root = new AnchorPane();
//            root.setPadding(new Insets(5.0));
//            Button button = createButton();
//            AnchorPane.setBottomAnchor(button, 0.0);
//            AnchorPane.setTopAnchor(button, 0.0);
//            AnchorPane.setBottomAnchor(button, 0.0);
//            AnchorPane.setRightAnchor(button, 0.0);
//            AnchorPane.setLeftAnchor(button, 0.0);
//
//            root.getChildren().add(button);
//            Scene scene = new Scene(root, 300, 300);
//            primaryStage.setTitle("Хабрахабр");
//            //primaryStage.getIcons().add(new Image(getResource("favicon-16x16.png").toExternalForm()));
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private Button createButton() {
//        Button result = new Button("Жми");
//        result.setTooltip(new Tooltip("Не бойся, жми!"));
//        result.setCursor(Cursor.HAND);
//        result.setOnMouseClicked(mouseEvent -> {
//           // new AudioClip(getResource("click.wav").toString()).play();
//            showDialog();
//
//        });
//        return result;
//    }
//
//    private URL getResource(String name) {
//        return getClass().getResource(name);
//    }
//
//    private void showDialog() {
//        Alert dialog = new Alert(AlertType.INFORMATION);
//        dialog.initStyle(StageStyle.UTILITY);
//        dialog.setTitle("Инфо");
//        dialog.setHeaderText("Привет мир!");
//        dialog.showAndWait();
//    }

    @Override
    public void start(Stage stage) throws Exception {

        //Label lbl = new Label();
        Label label1 = new Label("comment:");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
//        TextField textField = new TextField();
//        textField.setPrefColumnCount(11);
//        TextField textField1 = new TextField();
//        textField1.setPrefColumnCount(11);
//        Button btn = new Button("Click");
//        btn.setOnAction(event -> lbl.setText("Input: " + textField.getText() + " " + textField1.getText()));
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, hb);
       Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("JSON creater");
        stage.show();
    }

    public HBox createLabel(Label label){
        Label label1 = new Label("comment:");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        return hb;
    }
}
