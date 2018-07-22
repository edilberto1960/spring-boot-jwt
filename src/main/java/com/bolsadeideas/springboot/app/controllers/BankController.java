package com.bolsadeideas.springboot.app.controllers;


import com.bolsadeideas.springboot.app.models.entity.bank.BankAccount;
import com.bolsadeideas.springboot.app.models.service.bankservice.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.NestedServletException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bank")
public class BankController {

    @Autowired
    BankAccountService bankAccountService;

    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/addBankAccount/", method = RequestMethod.POST)
    public ResponseEntity<BankAccount> createUser(@RequestBody BankAccount bankAccount, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + bankAccount.getNameBank() );


        if (bankAccountService.findByAccount(bankAccount.getAccountNumber()) != null) {
            System.out.println("A User with name " + bankAccount.getNameBank() + " already exist");
            HttpHeaders headers = new HttpHeaders();
            headers.set("error ", "bank account already exist");
            return new ResponseEntity<BankAccount>(headers, HttpStatus.CONFLICT);
        }


        bankAccountService.save(bankAccount);
        BankAccount bank = bankAccountService.findByAccount(bankAccount.getAccountNumber());

        HttpHeaders headers = new HttpHeaders();
        headers.set("accepted ok","bank account is ok");

        return new ResponseEntity<BankAccount>(bank, headers, HttpStatus.CREATED);
    }

    //------------------- Update a Bank Account --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BankAccount> updateUser(@PathVariable("id") long id, @RequestBody BankAccount bankAccount) {
        System.out.println("Updating User " + id);

        try {
            BankAccount currentBankAcc = bankAccountService.findBankById(id).get();
            bankAccountService.save(bankAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.set("success", "the account is update success");
            return new ResponseEntity<BankAccount>(bankAccount,headers, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            System.out.println("User with id " + id + " not found");
            HttpHeaders headers = new HttpHeaders();
            headers.set("error", "la cuenta no existe");
            return new ResponseEntity<BankAccount>(headers, HttpStatus.NOT_FOUND);
        }



    }

    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/getAllBankAccounts/", method = RequestMethod.GET)
    public ResponseEntity<List<BankAccount>> listAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        List<BankAccount> bankAccounts = bankAccountService.findAll();
        List<String> stringList = new ArrayList<>();

        stringList.add("Bank 1");
        stringList.add("Bank 2");

        if (bankAccounts.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<BankAccount>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<BankAccount>>(bankAccounts, HttpStatus.OK);
    }

}
