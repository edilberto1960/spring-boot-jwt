package com.bolsadeideas.springboot.app.models.dao.budget;

import com.bolsadeideas.springboot.app.models.entity.accounts.BudgetAccountNumber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBudgetAccountNumber extends CrudRepository<BudgetAccountNumber, Long> {

	@Query("select p from BudgetAccountNumber p where p.name like %?1%")
	public List<BudgetAccountNumber> findByName(String term);
	
	public List<BudgetAccountNumber> findByNameLikeIgnoreCase(String term);
}
