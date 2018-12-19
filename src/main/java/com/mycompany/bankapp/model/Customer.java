package com.mycompany.bankapp.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alwan
 */

public class Customer {
    /*
    JSON FORMAT:
    	{
		"fullname" : "Julian Alwandy", 
		"address" : "Address", 
		"email":"Email", 
		"sortCode" : 0, 
		"balance" : 500
	}
    */
    public int accountId;
    public String fullname; 
    public String address; 
    public String email;
    public int sortCode;
    public int balance;
    public Customer() {} // To allow JSON
    
    public Customer(int accountId, String fullname, String address, String email, int sortCode, int balance){
        this.fullname = fullname;
        this.sortCode = sortCode;
        this.accountId = accountId;
        this.balance = balance;
        this.address = address;
        this.email = email;
    }

    public int withdraw(int amount) {
        if(balance - amount <= 0) {
           return 0; 
        } else {
            balance -= amount;
            return 1;
        }
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
}
