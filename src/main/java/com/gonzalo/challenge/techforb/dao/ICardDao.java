package com.gonzalo.challenge.techforb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.Card;

public interface ICardDao extends JpaRepository<Card, Long>{

}
