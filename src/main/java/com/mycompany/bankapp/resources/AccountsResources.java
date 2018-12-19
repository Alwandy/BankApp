/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.model.Transactions;
import com.mycompany.bankapp.service.AccountsService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author alwan
 */
@Path("/accounts")
public class AccountsResources {
       public AccountsService accountsService = new AccountsService();
              
       /*
       This GET method gets the account information
       */
       @GET
       @Path("/retrieve/{cId}")
       @Produces(MediaType.APPLICATION_JSON)
       public Customer getAccount(@PathParam("cId") int cId){
               return accountsService.getAccount(cId);
       }
              
       /*
       This POST method allows account creation
       */
       @POST
       @Consumes(MediaType.APPLICATION_JSON)
       @Produces(MediaType.TEXT_PLAIN)
       @Path("/create")
       public String createAccount(Customer c){
               int accountId = accountsService.getSize();
               accountsService.createAccount(accountId, c.fullname, c.address, c.email, c.sortCode, c.balance);
               return("Account created for " + c.fullname + " with account number:" + accountId);
       }
              
       /*
       This GET method allows transfering between accounts
       */
       @GET
       @Produces(MediaType.TEXT_PLAIN)
       @Path("/transfer/{cId}/{tId}/{amount}")
       public String transfer(@PathParam("cId") int customerId, @PathParam("tId") int targetId, @PathParam("amount") int amount){
               int error = accountsService.transfer(customerId, targetId, amount);
               if(error != 0){
               return("Transferred");
               } else {
                   return("An error occured, please check if target account exists or there's enough funds!");
               }
       }
         
       /*
       This GET method allows withdraw
       */     
       @GET
       @Produces(MediaType.TEXT_PLAIN)
       @Path("/withdraw/{cId}/{amount}")
       public String withdraw(@PathParam("cId") int customerId,@PathParam("amount") int amount){
               accountsService.withdraw(customerId, amount);
               return("Successfully withdrawn: " + amount);
       }
       
       /*
       This GET method allows deposit
       */
       @GET
       @Produces(MediaType.TEXT_PLAIN)
       @Path("/deposit/{cId}/{amount}")
       public String deposit(@PathParam("cId") int customerId,@PathParam("amount") int amount){
               accountsService.deposit(customerId, amount);
               return("Successfully deposited: " + amount);
       }
       
       /*
       This GET method returns in a JSON format all transaction history of given customer id
       */
       @GET
       @Produces(MediaType.APPLICATION_JSON)
       @Path("/history/{cId}")
       public Object history(@PathParam("cId") int customerId){
             return accountsService.getAllTransfersFromAccount(customerId);
       }
       
}
