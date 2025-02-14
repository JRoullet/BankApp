package jroullet83.msloans.Repository;

import jroullet83.msloans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Query(value = "SELECT * FROM LOAN WHERE customer_id =?", nativeQuery = true)
    List<Loan> getLoansByCustomerId(@Param ("customerId") int customerId);
}
