package com.example.cards.exception;

public class CardNotFoundException extends RuntimeException {
	public CardNotFoundException(Long id) {
		super("Could not find Card with ID = " + id);
	}
}
