package jroullet83.mscards.controller;

import jroullet83.mscards.config.CardConfig;
import jroullet83.mscards.dto.CustomerIdDto;
import jroullet83.mscards.model.Card;
import jroullet83.mscards.model.Properties;
import jroullet83.mscards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-cards")
@RequiredArgsConstructor
public class CardController {

    Logger logger = LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;
    private final CardConfig cardConfig;

    @PostMapping("/list")
    public ResponseEntity<List<Card>> getCards(@RequestBody CustomerIdDto customerIdDto) {
//        ||customerIdDto != customerController.getCustomers() // To complete the if statement
        if(customerIdDto == null) {
            logger.info("customerIdDto doesn't exist");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Card> cards = cardService.getCards(customerIdDto.getCustomerId());

        if(cards.isEmpty()) {
            logger.info("No cards found for customer id " + customerIdDto);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info(cards.size() + " card(s) found for customer id " + customerIdDto);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody Card card, Errors errors) {
        if(card == null) {
            logger.info("card insert is absent");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Card> cards = cardService.getCards(card.getCustomerId());

        boolean cardExists = cards.stream().anyMatch(existingCard -> existingCard.getCardId() == card.getCardId());

        if(!cardExists)
        {
            logger.debug(errors.toString());
            cardService.addCard(card);
            logger.info("card " + card.getCardId() +  " created");
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        }

        logger.info("card already exists");
//            cardService.updateCard(card);
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @GetMapping("/details/properties")
    public ResponseEntity<Properties> getPropertiesDetails() {
        Properties properties = new Properties(
                cardConfig.getMsg(),
                cardConfig.getBuildVersion(),
                cardConfig.getMailDetails(),
                cardConfig.getActiveBranches()
        );
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

//    @PutMapping
}
