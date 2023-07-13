package com.gonzalo.challenge.techforb.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends Card implements Serializable{
	
	//@NotNull
	//@Size(min=0)
	@Column(name = "credit_limit")
	private Double creditLimit;
	
	//@NotNull
	@Column(name = "cutoff_date")
	private Date cutoffDate;
	
	//@NotNull
	@Column(name = "payment_date")
	private Date paymentDate;
	
	public CreditCard() {
	}
	
	
	

	public Double getCreditLimit() {
		return creditLimit;
	}




	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}




	public Date getCutoffDate() {
		return cutoffDate;
	}




	public void setCutoffDate(Date cutoffDate) {
		this.cutoffDate = cutoffDate;
	}




	public Date getPaymentDate() {
		return paymentDate;
	}




	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
