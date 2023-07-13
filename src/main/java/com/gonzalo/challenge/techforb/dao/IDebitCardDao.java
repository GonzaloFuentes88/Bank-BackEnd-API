package com.gonzalo.challenge.techforb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.DebitCard;

public interface IDebitCardDao extends JpaRepository<DebitCard, Long> {

}
