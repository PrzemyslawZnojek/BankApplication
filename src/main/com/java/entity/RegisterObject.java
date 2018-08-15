package main.com.java.entity;

public class RegisterObject {

    private Account account;
    private Customer customer;
    private Users users;
    private Authorities authorities;

    public RegisterObject() {
    }

    public RegisterObject(Account account, Customer customer, Users users, Authorities authorities) {
        this.account = account;
        this.customer = customer;
        this.users = users;
        this.authorities = authorities;
    }

    public Account getAccount() { return account; }
    public Users getUsers() { return users; }
    public Customer getCustomer() {
        return customer;
    }
    public Authorities getAuthorities() { return authorities; }

    public void setAccount(Account account) { this.account = account; }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public void setAuthorities(Authorities authorities) { this.authorities = authorities; }
}
