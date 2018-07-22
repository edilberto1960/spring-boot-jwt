package com.bolsadeideas.springboot.app.controllers;


import com.bolsadeideas.springboot.app.models.entity.bank.BankTransaction;
import com.bolsadeideas.springboot.app.models.service.bankservice.BankAccountService;
import com.bolsadeideas.springboot.app.models.service.bankservice.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "api/transactions")
public class TransactionsController {

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    TransactionService transactionService;

    //@Autowired
   // AccountsDao accountsDao;


    //-------------------Retrieve All Type Transactions--------------------------------------------------------

    /*@RequestMapping(value = "/getAllAccounts/", method = RequestMethod.GET)
    public ResponseEntity<List<Accounts>> listAllTransactions() {
        List<Accounts> typeTransactions = (List<Accounts>) accountsDao.findAll();

        if (typeTransactions.isEmpty()) {
            return new ResponseEntity<List<Accounts>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Accounts>>(typeTransactions, HttpStatus.OK);
    }*/


    //-------------------Create a Transaction--------------------------------------------------------

    @PostMapping(value = "/add/")
    public ResponseEntity<Void> createUser(@RequestBody BankTransaction transactions, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + transactions.toString());


     /*   if (bankAccountService.findByAccount(bankAccount.getAccountNumber())!=null) {
            System.out.println("A User with name " + bankAccount.getNameBank() + " already exist");
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
        }*/

        transactionService.save(transactions);

        HttpHeaders headers = new HttpHeaders();
        headers.set("success","transaction grabada con exito");
        // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



}
