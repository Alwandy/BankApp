/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.service;
import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.model.Transactions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transaction;

/**
 *
 * @author alwan
 */
public class AccountsService {
    public static ArrayList<Customer> accounts = new ArrayList<>();
    public static ArrayList<Transactions> transactionsHistory = new ArrayList<>();

    public AccountsService(){}

    /*
    Create account 
    */
    public void createAccount(int accountId, String fullname, String address, String email, int sortCode, int balance) {
        accounts.add(new Customer(accountId, fullname, address, email, sortCode, balance));
    }
    
    /*
    Gets balance 
    */
    public int getBalance(int cId){
        return accounts.get(cId).balance;
    }
    
    /*
    Returns the account details 
    */
    public Customer getAccount(int cId){
        return accounts.get(cId);
    }
    
    /*
    Deposit money 
    */
    public void deposit(int cId, int amount){
        accounts.get(cId).deposit(amount);
        transactionsHistory.add(new Transactions(0, cId, amount));
    }
    
    /*
    Withdraw money 
    */
    public void withdraw(int cId, int amount){
        accounts.get(cId).withdraw(amount);
        transactionsHistory.add(new Transactions(1, cId, amount));
    }
    
    /*
    Transfers money between accounts 
    0 = failed 
    1 = succeeded 
    */
    public int transfer(int cId, int tcId, int amount){
        if(accounts.get(cId) != null || accounts.get(tcId) != null){
           int error = accounts.get(cId).withdraw(amount);
           if(error == 1) {
                accounts.get(tcId).deposit(amount);
                System.out.println("You have now successfully transferred " + amount + " to " + accounts.get(tcId).fullname);
                transactionsHistory.add(new Transactions(2, cId, amount));
                transactionsHistory.add(new Transactions(3, tcId, amount));
           } else {
                return 0;
           }
        } else {
            return 0;
        } 
        return 1;
    }
    
    /*
    To create unique id based on size of array list
    */
    public int getSize() {
        return accounts.size();
    }
    
    /*
    Gets the list of transactions of given customer 
    */
    public List<Transactions> getAllTransfersFromAccount(final int cId) {
        /* Create List */
        List<Transactions> transactionsList = new ArrayList<>();
        for(Transactions history : transactionsHistory) {
            if(history.getTransactions() == cId) {
                /* Add Items */
                transactionsList.add(history);
            }
        }
        /* Return List */
        return transactionsList;
    }
}
