package jroullet83.mscards.repository;

import jroullet83.mscards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository <Card,Integer> {

    @Query(value = "SELECT * FROM CARD WHERE CUSTOMER_ID = ?", nativeQuery = true)
    List<Card> getCardsByCustomerId(@Param ("customerId") int customerId);



}
