package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) {
        System.out.println("Save Customer Btn");
        int id = Integer.parseInt(txtCustomerID.getText());
        String name = txtCustomerName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Address : "+address);
        System.out.println("Salary : "+salary);

    }

}
