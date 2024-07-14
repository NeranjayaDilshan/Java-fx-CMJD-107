package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        System.out.println("Customer");
        URL resource = this.getClass().getResource("/view/Customer.fxml");
        Parent node = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.setScene(new Scene(node));
        stage.show();
        stage.setTitle("Customer Form");
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
