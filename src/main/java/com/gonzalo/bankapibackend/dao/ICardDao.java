package com.gonzalo.bankapibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bankapibackend.entitys.Card;

public interface ICardDao extends JpaRepository<Card, Long>{

}
