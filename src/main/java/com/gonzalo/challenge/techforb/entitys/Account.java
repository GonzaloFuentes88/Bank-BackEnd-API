package com.gonzalo.challenge.techforb.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accounts")
public class Account implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_number")
	private Long accountNumber;
	
	@NotNull
	//@Size(min=0)
	private Double balance;
	
	@NotNull
	@Column(name = "opneng_date")
	private Date openingDate;
	
	@OneToMany(mappedBy = "associatedAccount",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CreditCard> creditCards;
	
	@OneToMany(mappedBy = "associatedAccount",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DebitCard> debitCards;
	
	@OneToMany(mappedBy = "originAccount",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactionsMade;

	@OneToMany(mappedBy = "destinationAccuount",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactionsReceived;
	
	public Account() { 
		this.creditCards = new ArrayList<>();
		this.debitCards = new ArrayList<>();
		this.transactionsMade = new ArrayList<>();
		this.transactionsReceived = new ArrayList<>();
	}
	
	
	public void addCreditCard(CreditCard card) {
		card.setAssociatedAccount(this);
		this.creditCards.add(card);
	}
	public void addDebitCard(DebitCard card) {
		card.setAssociatedAccount(this);
		this.debitCards.add(card);
	}
	
	public void removeCreditCard(Long card) {
		this.creditCards.removeIf((a)-> a.getNumber() == card);
	}
	public void removeDebitCard(Long card) {
		this.debitCards.removeIf((a)-> a.getNumber() == card);
	}

	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public List<DebitCard> getDebitCards() {
		return debitCards;
	}

	public void setDebitCards(List<DebitCard> debitCards) {
		this.debitCards = debitCards;
	}

	public List<Transaction> getTransactionsMade() {
		return transactionsMade;
	}

	public void setTransactionsMade(List<Transaction> transactionsMade) {
		this.transactionsMade = transactionsMade;
	}

	public List<Transaction> getTransactionsReceived() {
		return transactionsReceived;
	}

	public void setTransactionsReceived(List<Transaction> transactionsReceived) {
		this.transactionsReceived = transactionsReceived;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
