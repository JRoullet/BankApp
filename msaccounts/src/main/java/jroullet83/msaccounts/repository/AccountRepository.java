package jroullet83.msaccounts.repository;

import jroullet83.msaccounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {

    @Query(value= "SELECT * FROM ACCOUNTS WHERE CUSTOMER_ID =?", nativeQuery = true)
    Account getAccountByCustomerId(@Param("customerId") Integer customerId);

}
