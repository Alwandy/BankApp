/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.service.AccountsService;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author alwan
 */
public class AccountsResources {
       public AccountsService accountsService = new AccountsService();
       
       @POST
       @Path("/createaccount")
       @Consumes(MediaType.APPLICATION_JSON)
       public Response createAccount(Customer customer){
           accountsService.createAccount(accountsService.getSize(), customer.fullName, customer.address, customer.email, customer.sortCode, customer.balance);
           return Response.status(201).build();
       }
       
       @GET
       @Path("/accounts")
       public String getAccounts(){
           return("Works");
       }
}
