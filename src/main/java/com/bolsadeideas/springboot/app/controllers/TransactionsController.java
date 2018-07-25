package com.bolsadeideas.springboot.app.controllers;


import com.bolsadeideas.springboot.app.models.entity.bank.BankTransaction;
import com.bolsadeideas.springboot.app.models.service.bankservice.BankAccountService;
import com.bolsadeideas.springboot.app.models.service.bankservice.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    //-------------------Get Transactions Report--------------------------------------------------------

    @RequestMapping(value = "/transaction/{id}/{ini}/{fin}", method = RequestMethod.GET)
    public ResponseEntity<List<BankTransaction>> getTransactionByBankAccount(@PathVariable(value = "id") Long id,
                                                                             @PathVariable(value = "ini") String ini, @PathVariable(value = "fin") String fin ) {
        System.out.println("GET REPORTS_: " + id);
        System.out.println("GET REPORTS_: " + ini);
        System.out.println("GET REPORTS_: " + fin);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = ini;
        String dateFinStrig = fin;
        Date initialDate = null;
        Date finalDate = null;
        try {

             initialDate = formatter.parse(dateInString);
            System.out.println(initialDate);
            System.out.println(formatter.format(initialDate));

            finalDate = formatter.parse(dateFinStrig);
            System.out.println(finalDate);
            System.out.println(formatter.format(finalDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<BankTransaction> transactionsList = transactionService.findTransactionsbyDate( id , initialDate, finalDate);


        return new ResponseEntity<List<BankTransaction>>(transactionsList, HttpStatus.OK);
    }


        // List<Object[]> objects = transactionService.getSumCheckAmountByDepartmentByType(getTransaction.getInitialDate(), getTransaction.getFinalDate());

//        for (BankTransaction t : transactionsList) {
//
//            System.out.println("Transactions " + t.getId() + " " + t.getDepositAmount());
//        }
//        if (transactionsList.isEmpty()) {
//            return new ResponseEntity<List<BankTransaction>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<BankTransaction>>(transactionsList, HttpStatus.OK);




    //-------------------Create a Transaction--------------------------------------------------------

    @PostMapping(value = "/add/")
    public ResponseEntity<Void> createUser(@RequestBody BankTransaction transactions, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + transactions.toString());

        System.out.println("Date " + transactions.getDate());


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
