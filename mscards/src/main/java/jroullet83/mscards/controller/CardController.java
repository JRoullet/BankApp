package jroullet83.mscards.controller;

import jroullet83.mscards.model.Card;
import jroullet83.mscards.service.CardService;
import lombok.RequiredArgsConstructor;
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

    @Autowired
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<List<Card>> getCards(@PathVariable int customerId) {
        List<Card> cards = cardService.getCards(customerId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
