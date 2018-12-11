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

/**
 *
 * @author alwan
 */
public class AccountsService {
    public static ArrayList<Customer> accounts = new ArrayList<>();
    public static ArrayList<Transactions> transactionsHistory = new ArrayList<>();

    public AccountsService(){}

    public String createAccount(int accountId, String fullName, String address, String email, int sortCode, int balance) {
        accounts.add(new Customer(accountId, fullName, address, email, sortCode, balance));
        return ("We have now successfully created account with account id: " + accountId);
    }

    public void getBalance(int cId){
        System.out.println("Balance: " + accounts.get(cId).balance);
    }
    
    public void deposit(int cId, int amount){
        accounts.get(cId).deposit(amount);
        transactionsHistory.add(new Transactions(0, cId, amount));
    }

    public void withdraw(int cId, int amount){
        accounts.get(cId).withdraw(amount);
        transactionsHistory.add(new Transactions(1, cId, amount));
    }

    public void transfer(int cId, int tcId, int amount){
        accounts.get(cId).withdraw(amount);
        accounts.get(tcId).deposit(amount);
        System.out.println("You have now successfully transferred " + amount + " to " + accounts.get(tcId).fullName);
        transactionsHistory.add(new Transactions(2, cId, amount));
        transactionsHistory.add(new Transactions(3, tcId, amount));
    }

    public int getSize() {
        return accounts.size();
    }

    public Iterator<Customer> getAllAccounts(){
        return accounts.iterator();
    }

    public void getAllTransfersFromAccount(int cId) {
        System.out.println("Checking account transaction of " + accounts.get(cId).fullName);
        for(Transactions history : transactionsHistory) {
            if(history.getTransactions() == cId) {
                switch(history.transType) {
                    case 0:
                        System.out.println("Transaction: Deposit Amount: " + history.amount);
                        break;
                    case 1:
                        System.out.println("Transaction: Withdraw Amount: " + history.amount);
                        break;
                    case 2:
                        System.out.println("Transaction: Transfer Amount: " + history.amount);
                        break;
                    case 3:
                        System.out.println("Transaction: Transfer Received Amount: " + history.amount);
                        break;
                }
            }
        }
    }
}
