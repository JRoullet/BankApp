package jroullet83.mscards.service;

import jakarta.transaction.Transactional;
import jroullet83.mscards.model.Card;
import jroullet83.mscards.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards(int customerId) {
        return cardRepository.getCardsByCustomerId(customerId);
    }

    public void addCard(Card card) {
        card.setCardId(card.getCardId());
        cardRepository.save(card);
    }
}
