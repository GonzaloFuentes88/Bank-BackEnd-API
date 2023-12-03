package com.gonzalo.bankapibackend.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Date date;
	
	@NotNull
	private Double amount;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "origin_account")
	@JsonIgnore
	private Account originAccount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detination_account")
	@JsonIgnore
	private Account destinationAccuount;
	
	@NotNull
	@Column(name="transaction_type")
	private Integer transactionType;
	
	
	
	public Transaction() {
	}


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





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}
	
	



	public Account getOriginAccount() {
		return originAccount;
	}


	public void setOriginAccount(Account originAccount) {
		this.originAccount = originAccount;
	}


	public Account getDestinationAccuount() {
		return destinationAccuount;
	}





	public void setDestinationAccuount(Account destinationAccuount) {
		this.destinationAccuount = destinationAccuount;
	}





	public Integer getTransactionType() {
		return transactionType;
	}





	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	
	




	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}







	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
