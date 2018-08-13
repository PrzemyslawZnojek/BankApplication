package main.com.java.entity;

public class RegisterObject {

    private Account account;
    private Customer customer;
    private Users users;

    public RegisterObject() {
    }

    public RegisterObject(Account account, Customer customer, Users users) {
        this.account = account;
        this.customer = customer;
        this.users = users;
    }

    public Account getAccount() { return account; }
    public Users getUsers() {
        return users;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setAccount(Account account) { this.account = account; }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
}
