package jroullet83.mscards.service;

import jroullet83.mscards.model.Card;
import jroullet83.mscards.repository.CardRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards(int customerId) {
        return cardRepository.getCardsByCustomerId(customerId);
    }
}
