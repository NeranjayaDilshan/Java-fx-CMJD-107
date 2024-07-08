package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        System.out.println("Customer");
    }

    @FXML
    void btnItemOnAction(ActionEvent event) {
        System.out.println("Item");

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {
        System.out.println("Orders");

    }

}
