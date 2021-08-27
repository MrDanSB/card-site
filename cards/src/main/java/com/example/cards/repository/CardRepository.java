package com.example.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cards.entity.Card;

/**
 * Repository definition for cards entities
 * 
 * @author Daniel Phillips
 *
 */
public interface CardRepository extends JpaRepository<Card,Long> {
	
}
