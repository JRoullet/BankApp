package jroullet83.msaccounts.repository;

import jroullet83.msaccounts.model.Accounts;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository <Accounts, Integer> {

    @Query(value= "SELECT * FROM ACCOUNTS WHERE CUSTOMER_ID =?1", nativeQuery = true)
    Accounts getAccountsByCustomerId(@Param("customerId") Integer customerId);

}
