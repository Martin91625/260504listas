package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

@SuppressWarnings("unused")
public class MainSceneController {

    
    @FXML
    private Button addFruitButton;

    @FXML
    private TextField fruitTextField;

    @FXML
    private ListView<String> list1;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;


    @FXML
    private void initialize() {
        addFruitButton.setOnAction(e -> onClickAddFruitButton());
        saveButton.setOnAction(e -> onClickSaveButton());
        deleteButton.setOnAction(e -> onClickDeleteButton());
        String[] content = {"alma", "körte", "barack", "szilva"};
        list1.getItems().addAll(content);
    }

    private void onClickAddFruitButton() {
        list1.getItems().add(fruitTextField.getText());
        fruitTextField.setText("");
    }

    private void onClickSaveButton() {
        fruitTextField.setText("");
    }

    private void onClickDeleteButton() {
        list1.getItems().remove(fruitTextField.getText());
        fruitTextField.setText("");
    }
}