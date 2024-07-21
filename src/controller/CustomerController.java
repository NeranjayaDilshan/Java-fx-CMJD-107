package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

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
    void btnSaveCustomerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("Save Customer Btn");
        int id = Integer.parseInt(txtCustomerID.getText());
        String name = txtCustomerName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Address : " + address);
        System.out.println("Salary : " + salary);

        Customer customer = new Customer(id, name, address, salary);

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
        statement.setObject(1, customer.getCustomerID());
        statement.setObject(2, customer.getCustomerName());
        statement.setObject(3, customer.getAddress());
        statement.setObject(4, customer.getSalary());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Saved Success");
            new Alert(Alert.AlertType.CONFIRMATION,"Saved Success").show();
        } else {
            System.out.println("Error while Saving Cusotmer");
            new Alert(Alert.AlertType.ERROR,"Error while Saving Cusotmer").show();
        }
    }


    @FXML
    void btnLoadAllCusotmerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        // Connection connection = DBConnection.getInstance().getConnection();
        // PreparedStatement statement = connection.prepareStatement("SELECT * from customer");
        // ResultSet executeQuery = statement.executeQuery();
        ResultSet customerSet = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer").executeQuery();

        ArrayList<Customer> customersList = new ArrayList<Customer>();

        while (customerSet.next()) {
            Customer customer = new Customer(
                customerSet.getInt(1),
                customerSet.getString(2),
                customerSet.getString(3),
                customerSet.getDouble(4)
            );
            customersList.add(customer);
        }
        System.out.println(customersList);

    }
}
