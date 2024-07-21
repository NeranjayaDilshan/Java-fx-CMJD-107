package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import tm.CustomerTM;

public class CustomerController {

    @FXML
    private TableColumn<CustomerTM, String> colName;

    @FXML
    private TableColumn<CustomerTM, String> colAction;

    @FXML
    private TableColumn<CustomerTM, String> colAddress;

    @FXML
    private TableColumn<CustomerTM, Integer> colID;

    @FXML
    private TableColumn<CustomerTM, Double> colSalary;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtSalary;

    public void initialize() throws ClassNotFoundException, SQLException {
        System.out.println("Calling first");
        colID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
       
        getAllCustomer();
    }

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
            getAllCustomer();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Success").show();
        } else {
            System.out.println("Error while Saving Cusotmer");
            new Alert(Alert.AlertType.ERROR, "Error while Saving Cusotmer").show();
        }
    }

    public void getAllCustomer() throws ClassNotFoundException, SQLException {
        // Connection connection = DBConnection.getInstance().getConnection();
        // PreparedStatement statement = connection.prepareStatement("SELECT * from
        // customer");
        // ResultSet executeQuery = statement.executeQuery();
        ResultSet customerSet = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer")
                .executeQuery();

        ArrayList<Customer> customersList = new ArrayList<Customer>();

        while (customerSet.next()) {
            Customer customer = new Customer(
                    customerSet.getInt(1),
                    customerSet.getString(2),
                    customerSet.getString(3),
                    customerSet.getDouble(4));
            customersList.add(customer);
        }
        System.out.println(customersList);

        //////////////////////////////////////////////////////////////

        ObservableList<CustomerTM> customerTmList = FXCollections.observableArrayList();

        for (Customer cust : customersList) {

            Button button = new Button("Delete");

            CustomerTM customerTM = new CustomerTM(
                    cust.getCustomerID(),
                    cust.getCustomerName(),
                    cust.getAddress(),
                    cust.getSalary(),
                    button);

            customerTmList.add(customerTM);
        }
        System.out.println(" customerTmList :  " + customerTmList);

        tblCustomer.setItems(customerTmList);
    }

    @FXML
    void btnLoadAllCusotmerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        getAllCustomer();
    }
}
