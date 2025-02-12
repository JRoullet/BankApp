//package jroullet83.msaccounts.mixin;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import java.time.LocalDate;
//
//
//public abstract class AccountMixIn {
//
//    @JsonCreator
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public AccountMixIn(
//    @JsonProperty ("customer_id") int customerId,
//    @JsonProperty ("account_number") long accountNumber,
//    @JsonProperty ("account_type")String accountType,
//    @JsonProperty ("bank_address") String bankAddress,
//    @JsonProperty ("create_dt") LocalDate createDt
//    )
//    {
//    }
//
//}
//
