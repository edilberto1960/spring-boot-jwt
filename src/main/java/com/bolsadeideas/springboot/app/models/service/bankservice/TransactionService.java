package com.bolsadeideas.springboot.app.models.service.bankservice;

import com.bolsadeideas.springboot.app.models.entity.bank.BankTransaction;

import java.util.Date;
import java.util.List;


public interface TransactionService {

    public void save(BankTransaction transaction);

//    public void updateBalance(Transaction transactions);
//
//    List<Transaction> findTransactionsbyDate(Long id, Date start, Date end);
//
//    Transaction findTransactionById(long id);
//
//    void delete(long id);
//
//    List<Object[]> getSumCheckAmountByDepartmentByType(Date initial, Date finalDate);
//
//    List<Object[]> getSumDepositAmountByDepartmentByType(Date initial, Date finalDate);

	/* void getTransactionsOver(@Param("start") Date start, Transactions transaction);
	 List<Transactions> getTransactions();
	 List<Transactions> findTransactionsbyDate(int id, Date start, Date end);
	 Transactions getTransactionById(long id);
	 void deleteTransactions(@Param("start") Date start, Transactions transaction);
	 Transactions findTransactionsById(long id);
	void updateTransactions(Date start, Transactions transaction);*/


}
