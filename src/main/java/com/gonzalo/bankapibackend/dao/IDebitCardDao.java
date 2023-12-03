package com.gonzalo.bankapibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bankapibackend.entitys.DebitCard;

public interface IDebitCardDao extends JpaRepository<DebitCard, Long> {

}
