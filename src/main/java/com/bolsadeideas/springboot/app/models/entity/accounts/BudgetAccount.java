package com.bolsadeideas.springboot.app.models.entity.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "budget_account")
public class BudgetAccount implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer cantidad;

    @Column
    private Double credit;

    @Column
    private Double debit;

    @Column
    private Double balance;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="budget_account_number_id")
    private BudgetAccountNumber budgetAccountNumber;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public BudgetAccountNumber getBudgetAccountNumber() {
        return budgetAccountNumber;
    }

    public void setBudgetAccountNumber(BudgetAccountNumber budgetAccountNumber) {
        this.budgetAccountNumber = budgetAccountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
