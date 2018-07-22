package com.bolsadeideas.springboot.app.models.service.bankservice;

import com.bolsadeideas.springboot.app.models.dao.bankdao.BankDao;
import com.bolsadeideas.springboot.app.models.entity.bank.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankAccountServiceImp implements BankAccountService {

    @Autowired
    BankDao bankDao;

     @Override
    public void save(BankAccount bank) {
        bankDao.save(bank);


    }

    @Override
    public BankAccount findByAccount(Long accountNumber) {
        return bankDao.findByAccountNumber(accountNumber);
    }

    @Override
    public Optional<BankAccount> findBankById(long id) {
        return bankDao.findById(id);
    }

    @Override
    public List<BankAccount> findAll() {
       return (List<BankAccount>) bankDao.findAll();
    }


   /* @Override
    public List<BankAccount> findAll() {
        // TODO Auto-generated method stub
        return bankDao.findAll();
    }

    @Override
    public BankAccount findBankById(long id) {
        return null;
    }

    @Override
    public BankAccount findOne(Long id) {
        // TODO Auto-generated method stub
        return bankDao.findById(id).get();
    }

    @Override
    public void update(BankAccount bank) {
        bankDao.save(bank);
        updateBalance(bank);

    }

    @Override
    public void delete(BankAccount bank) {
        bankDao.delete(bank);

    }

    @Override
    public BankAccount findByAccount(Long accountNumber) {
        return bankDao.findByAccountNumber(accountNumber);
    }

    @Override
    public List<BankAccount> findByName(String name) {

        return bankDao.findByNameBank(name);
    }


    public void updateBalance(BankAccount bankAccount) {
        Optional<BankAccount> currentUser = bankDao.findById(bankAccount.getId());
        Double balance = currentUser.get().getBalance();
        //	System.out.println("BALANCE NUEVO GRABADO " + balance);
        List<Transactions> transactionsList = transactionDao.getAlltransactionsOrderByASC(bankAccount.getId());

        for (Transactions t : transactionsList) {
            //	System.out.println("VALOR DEL BALANCE DE ENTRADA:  " + balance);
            balance = balance + t.getDepositAmount() - t.getCheckAmount();
            //		System.out.println("BALANCE UPDATE BANK ACCOUNT"+ balance + " Deposit: " + t.getDepositAmount());
            t.setBalance(balance);

            transactionDao.save(t);
        }

    }
*/
}
