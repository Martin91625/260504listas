package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class MainSceneController {

    
    @FXML
    private Button addFruitButton;

    @FXML
    private TextField fruitTextField;

    @FXML
    private ListView<String> list1;

    @FXML
    private Button modifyButton;

    @FXML
    private Button deleteButton;


    @FXML
    private void initialize() {
        initEvent();
        String[] content = {"alma", "körte", "barack", "szilva"};
        list1.getItems().addAll(content);
    }

    private void initEvent() {
        addFruitButton.setOnAction(e -> onClickAddFruitButton());
        modifyButton.setOnAction(e -> onClickModifyButton());
        deleteButton.setOnAction(e -> onClickDeleteButton());
        list1.setOnMouseClicked(e -> onClickList(e));
    }

    private void onClickAddFruitButton() {
        if(!fruitTextField.getText().equals("")) {
            list1.getItems().add(fruitTextField.getText());
            fruitTextField.setText("");
        }
        
    }

    private void onClickModifyButton() {
        if(!fruitTextField.getText().equals("")) {    
            int index = list1.getSelectionModel().getSelectedIndex();
            list1.getItems().set(index, fruitTextField.getText());
            fruitTextField.setText("");
            list1.setDisable(false);
        }
    }

    private void onClickDeleteButton() {
        list1.getItems().remove(fruitTextField.getText());
        fruitTextField.setText("");
    }

    private void onClickList(MouseEvent e) {
        if(e.getClickCount() == 2 && e.getButton().equals(MouseButton.PRIMARY)) {
            String selected = list1.getSelectionModel().getSelectedItem();
            fruitTextField.setText(selected);
            list1.setDisable(true);
        }
    }
}