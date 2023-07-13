package com.gonzalo.challenge.techforb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.CreditCard;

public interface ICreditCardDao extends JpaRepository<CreditCard, Long> {

}
