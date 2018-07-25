package com.bolsadeideas.springboot.app.models.entity.bank;

import com.bolsadeideas.springboot.app.models.entity.accounts.BudgetAccount;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "bank_transaction")
public class BankTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    //@Temporal(TemporalType.DATE)
   // @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date date;


    @Column(name = "operationDate")
    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date operationDate;

    //@Size(min= 2, max = 25)
    @Column(name = "reference")
    private String reference;

    @Column(name = "description")
    private String description;

    @Column(name = "expanded_to")
    private String expandedTo;

    private String status;

    @NumberFormat(style = Style.CURRENCY)
    @Column(name = "deposit_amount")
    private double depositAmount;

    @NumberFormat(style = Style.CURRENCY)
    @Column(name = "check_amount")
    private double checkAmount;

    private Double Balance;

    @ManyToOne(fetch = FetchType.EAGER)
    private BankAccount bankAccount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bank_transaction_id")
    private List<BudgetAccount> budgetAccounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Date getOperationDate() {
        return operationDate;
    }


    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }


    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getExpandedTo() {
        return expandedTo;
    }


    public void setExpandedTo(String expandedTo) {
        this.expandedTo = expandedTo;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public double getDepositAmount() {
        return depositAmount;
    }


    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }


    public double getCheckAmount() {
        return checkAmount;
    }


    public void setCheckAmount(double checkAmount) {
        this.checkAmount = checkAmount;
    }


    public Double getBalance() {
        return Balance;
    }


    public void setBalance(Double balance) {
        Balance = balance;
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }


    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<BudgetAccount> getBudgetAccounts() {
        return budgetAccounts;
    }

    public void setBudgetAccounts(List<BudgetAccount> budgetAccounts) {
        this.budgetAccounts = budgetAccounts;
    }

    @Override
    public String toString() {
        return "BankTransaction{" + "id=" + id + ", date=" + date + ", operationDate=" + operationDate + ", reference='" + reference + '\'' + ", description='" + description + '\'' + ", expandedTo='" + expandedTo + '\'' + ", status='" + status + '\'' + ", depositAmount=" + depositAmount + ", checkAmount=" + checkAmount + ", Balance=" + Balance + ", bankAccount=" + bankAccount.getNameBank() + ", budgetAccounts=" + budgetAccounts + '}';
    }
}
