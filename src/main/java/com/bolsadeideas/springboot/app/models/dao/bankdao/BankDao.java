package com.bolsadeideas.springboot.app.models.dao.bankdao;

import com.bolsadeideas.springboot.app.models.entity.bank.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BankDao extends CrudRepository<BankAccount, Long> {


     BankAccount findByAccountNumber(Long accountNumber);

     Optional<BankAccount> findById(Long id);


     /* List<BankAccount> findAll();

    @Override
    Optional<BankAccount> findById(Long id);

    BankAccount findByAccountNumber(Long accountNumber);

    List<BankAccount> findByNameBank(String name);
*/

}
