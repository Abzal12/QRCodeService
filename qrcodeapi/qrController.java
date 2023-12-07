package qrcodeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class qrController {

    @GetMapping("/api/health")
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("200", HttpStatus.OK);
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<String> getQrCode() {
        return new ResponseEntity<>("501", HttpStatus.NOT_IMPLEMENTED);
    }

}
