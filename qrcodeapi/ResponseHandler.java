package qrcodeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
//        map.put("message", message);
//        map.put("status", status.value());
        map.put("error", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
}
