package com.example.cards.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.cards.entity.Card;
import com.example.cards.exception.CardNotFoundException;
import com.example.cards.repository.CardRepository;

/**
 * Service for manipulate cards operations
 * 
 * @author Daniel Phillips
 *
 */
@Service
public class CardService implements CardInterface{

	// Card Repository
	@Autowired
	CardRepository repository;

	/**
	 * Save card
	 * 
	 * @param card
	 * @return
	 */
	@Override
	public Card saveCard(Card card) {
		return repository.save(card);
	}
	
	/**
	 * Update card
	 * 
	 * @param card
	 * @param id
	 * @return
	 */
	@Override
	public Card updateCard(Card card, Long id) {
		Optional<Card> opt = repository.findById(id);
		if(!opt.isPresent()) {
			throw new CardNotFoundException(id);
		}
		
		card.setCardid(id);
		repository.save(card);
		return repository.save(card);
	}

	/**
	 * Get card
	 * 
	 * @param cardid
	 * @return
	 */
	@Override
	public Card getCard(Long cardid) {
		return repository.findById(cardid).orElseThrow(() -> new CardNotFoundException(cardid));
	}

	/**
	 * Get card list
	 * 
	 * @return
	 */
	@Override
	public Page<Card> getCardList(Optional<Integer> page, Optional<String> sortBy) {
		return repository.findAll(PageRequest.of(page.orElse(0),10, Sort.Direction.DESC, sortBy.orElse("createdate")));
	}

	/**
	 * Delete card
	 * 
	 * @param cardid
	 * @return
	 */
	@Override
	public void deleteCard(Long cardid) {
		Optional<Card> opt = repository.findById(cardid);
		if(opt.isPresent()) {
			Card card = opt.get();
			repository.delete(card);
		} else {
			throw new CardNotFoundException(cardid);
		}
	}
	
	
}
