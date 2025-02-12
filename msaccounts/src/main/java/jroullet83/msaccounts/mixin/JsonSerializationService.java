//package jroullet83.msaccounts.mixin;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JsonSerializationService {
//
//    private final ObjectMapper objectMapper;
//
//    public JsonSerializationService() {
//        this.objectMapper = new JsonMixInConfig().getObjectMapper();
//    }
//
//    public <T> T deserialize(String json, TypeReference<T> typeReference) throws JsonProcessingException {
//        return objectMapper.readValue(json,typeReference);
//    }
//
//    public String serialize(Object object) throws JsonProcessingException {
//        return objectMapper.writeValueAsString(object);
//    }
//}
