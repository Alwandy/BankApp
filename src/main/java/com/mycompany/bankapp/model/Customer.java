package com.mycompany.bankapp.model;

/**
 *
 * @author alwan
 */
public class Customer {
    public String fullName, address, email;
    public int accountId, balance, sortCode;

    public Customer(int accountId, String fullName, String address, String email, int sortCode, int balance){
        this.fullName = fullName;
        this.sortCode = sortCode;
        this.accountId = accountId;
        this.balance = balance;
        this.address = address;
        this.email = email;
    }

    public void withdraw(int amount) {
        if(balance - amount <= 0) {
            System.out.println("Not enough balance to withdraw this amount, current balance is: " + balance);
        }
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
