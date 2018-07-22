package com.bolsadeideas.springboot.app.models.service.bankservice;

import com.bolsadeideas.springboot.app.models.entity.bank.BankAccount;

import java.util.List;
import java.util.Optional;


public interface BankAccountService {


    void save(BankAccount bank);

    BankAccount findByAccount(Long accountNumber);
    Optional<BankAccount> findBankById(long id);
    List<BankAccount> findAll();

   /* BankAccount findBankById(long id);

    List<BankAccount> findAll();

    BankAccount findOne(Long id);

    void update(BankAccount bank);

    void delete(BankAccount bank);

    BankAccount findByAccount(Long accountNumber);

    List<BankAccount> findByName(String name);*/


}
