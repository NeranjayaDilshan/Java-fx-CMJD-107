package tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private int customerID;
    private String customerName;
    private String Address;
    private Double salary;
    private Button btnDelete;
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    public CustomerTM(int customerID, String customerName, String address, Double salary, Button btnDelete) {
        this.customerID = customerID;
        this.customerName = customerName;
        Address = address;
        this.salary = salary;
        this.btnDelete = btnDelete;
    }
    public CustomerTM() {
    }
    @Override
    public String toString() {
        return "CustomerTM [customerID=" + customerID + ", customerName=" + customerName + ", Address=" + Address
                + ", salary=" + salary + ", btnDelete=" + btnDelete + "]";
    }

    
}
