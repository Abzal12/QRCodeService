package qrcodeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;

@RestController
public class qrController {

    @GetMapping("/api/health")
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("200", HttpStatus.OK);
    }

//    @GetMapping("/api/qrcode")
//    public ResponseEntity<String> getQrCode() {
//        return new ResponseEntity<>("501", HttpStatus.NOT_IMPLEMENTED);
//    }

    @GetMapping("api/qrcode")
    public ResponseEntity<BufferedImage> getImage() {
        BufferedImage bufferedImage = createImage();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bufferedImage);
    }

    private static BufferedImage createImage() {
        int width = 250;
        int height = 250;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.dispose();

        return image;
    }
}
