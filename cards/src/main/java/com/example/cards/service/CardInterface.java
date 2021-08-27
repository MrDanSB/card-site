package com.example.cards.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.cards.entity.Card;

/**
 * Card Interface of operations
 * 
 * @author Daniel Phillips
 *
 */
public interface CardInterface {
	/**
	 * Save card
	 * 
	 * @param card
	 * @return
	 */
	Card saveCard(Card card);
	/**
	 * Update Card
	 * 
	 * @param card
	 * @param id
	 * @return
	 */
	Card updateCard(Card card, Long id);
	/**
	 * Get card
	 * 
	 * @param cardid
	 * @return
	 */
	Card getCard(Long cardid);
	/**
	 * Get Card List
	 * 
	 * @return
	 */
	Page<Card> getCardList(Optional<Integer> page, Optional<String> sortBy);
	/**
	 * Delete a card
	 */
	void deleteCard(Long cardid);
}
