/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.model;

/**
 *
 * @author alwan
 */
public class Transactions {
    /**
     *  TRANS TYPE
     * 0 - Deposit
     * 1 - Withdrawal
     * 2 - Transfer
     * 3 - Transfer Receive
     */
    public int cId, amount, transType;
    public Transactions(int transType, int cId, int amount){
        this.transType = transType;
        this.cId = cId;
        this.amount = amount;
    }

    public int getTransactions(){
        return cId;
    }
}
