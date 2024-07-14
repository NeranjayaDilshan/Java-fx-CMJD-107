package model;

public class Customer {

    private int customerID;
    private String customerName;
    private String Address;
    private Double salary;
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
    public Customer(int customerID, String customerName, String address, Double salary) {
        this.customerID = customerID;
        this.customerName = customerName;
        Address = address;
        this.salary = salary;
    }
    public Customer() {
    }
    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", Address=" + Address
                + ", salary=" + salary + "]";
    }

    
}
