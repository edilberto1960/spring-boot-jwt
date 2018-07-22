package com.bolsadeideas.springboot.app.models.service.bankservice;

import com.bolsadeideas.springboot.app.models.dao.bankdao.TransactionDao;
import com.bolsadeideas.springboot.app.models.entity.bank.BankTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class TransactionServiceImp implements TransactionService {


    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    TransactionDao transactionDao;

    @Override
    public void save(BankTransaction transaction) {
        transactionDao.save(transaction);
       // updateBalance(transaction);
    }

//    @Override
//    public void updateBalance(Transaction transactions) {
//        Double balance = transactions.getBankAccount().getBalance();
//        List<Transaction> transactionsList = transactionDao.getAlltransactionsOrderByASC(transactions.getBankAccount().getId());
//
//        for (Transaction t : transactionsList) {
//
//            balance = balance + t.getDepositAmount() - t.getCheckAmount();
//            t.setBalance(balance);
//            transactionDao.save(t);
//        }
//
//    }
//
//    @Override
//    public List<Transaction> findTransactionsbyDate(Long id, Date start, Date end) {
//
//        return transactionDao.findTransactionsbyDate(id, start, end);
//
//    }
//
//    @Override
//    public Transaction findTransactionById(long id) {
//
//        return transactionDao.findTransactionsById(id);
//
//    }
//
//    @Override
//    public void delete(long id) {
//        transactionDao.deleteTransactionsById(id);
//    }
//
//    @Override
//    public List<Object[]> getSumCheckAmountByDepartmentByType(Date initial, Date finalDate) {
//        return transactionDao.getSumCheckAmountByDepartmentByType(initial, finalDate);
//    }
//
//    @Override
//    public List<Object[]> getSumDepositAmountByDepartmentByType(Date initial, Date finalDate) {
//        return transactionDao.getSumDepositAmountByDepartmentByType(initial, finalDate);
//    }
}
