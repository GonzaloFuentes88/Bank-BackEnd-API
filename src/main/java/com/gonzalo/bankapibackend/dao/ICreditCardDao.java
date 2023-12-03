package com.gonzalo.bankapibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bankapibackend.entitys.CreditCard;

public interface ICreditCardDao extends JpaRepository<CreditCard, Long> {

}
