package jroullet83.mscards.controller;

import jroullet83.mscards.model.Card;
import jroullet83.mscards.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/my-cards")
public class CardController {

    Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<List<Card>> getCards(@PathVariable Integer customerId) {
        if(customerId == null) {
            logger.info("customerId doesn't exist");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Card> cards = cardService.getCards(customerId);

        if(cards.isEmpty()) {
            logger.info("No cards found for customer id " + customerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info(cards.size() + " card(s) found for customer id " + customerId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
