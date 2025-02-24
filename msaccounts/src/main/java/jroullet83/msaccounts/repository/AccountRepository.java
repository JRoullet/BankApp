package jroullet83.msaccounts.repository;

import jroullet83.msaccounts.model.Account;
import jroullet83.msaccounts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {

    @Query(value= "SELECT * FROM ACCOUNT WHERE CUSTOMER_ID =?", nativeQuery = true)
    List<Account> getAccountsByCustomerId(@Param("customerId") Integer customerId);

}
