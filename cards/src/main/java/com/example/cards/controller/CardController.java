package com.example.cards.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cards.entity.Card;
import com.example.cards.service.CardService;

/**
 * Cards Controller
 * 
 * @author Daniel Phillips
 *
 */
@RestController
@RequestMapping("/rest")
public class CardController {
	
	// Card Service
	@Autowired
	CardService cardService;

	/**
	 * Save Card
	 * 
	 * @return 
	 */
	@PostMapping(value = "/cards", consumes = "application/json", produces = "application/json")
	public Card saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}
	/**
	 * Update Card
	 * 
	 * @param card
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/cards/{id}", consumes = "application/json", produces = "application/json")
	public Card updateCard(@RequestBody Card card, @PathVariable Long id) {
		return cardService.updateCard(card, id);	
	}
	/**
	 * Get Card
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/cards/{id}")
	public Card getCard(@PathVariable Long id) {
		return cardService.getCard(id);
	}
	/**
	 * get all cards method
	 * 
	 * @param page
	 * @param sortBy
	 * @return
	 */
	@GetMapping("/cards")
	public Page<Card> getAllCards(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
		return cardService.getCardList(page, sortBy);
	}
	/**
	 * Delete Card method
	 * 
	 * @param id
	 */
	@DeleteMapping("/cards/{id}")
	public void deleteCard(@PathVariable Long id) {
		cardService.deleteCard(id);
	}

}
