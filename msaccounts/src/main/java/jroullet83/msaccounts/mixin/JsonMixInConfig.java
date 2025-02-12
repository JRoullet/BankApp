//package jroullet83.msaccounts.mixin;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jroullet83.msaccounts.model.Account;
//
//
//public class JsonMixInConfig {
//
//    private final ObjectMapper objectMapper;
//
//    public JsonMixInConfig() {
//        objectMapper = new ObjectMapper();
//        objectMapper.addMixIn(Account.class, AccountMixIn.class);
//    }
//
//    public ObjectMapper getObjectMapper() {
//        return objectMapper;
//    }
//
//
//}
//
