package qrcodeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class qrController {

    @GetMapping("/api/health")
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("200", HttpStatus.OK);
    }

//    @GetMapping("/api/qrcode")
//    public ResponseEntity<String> getQrCode() {
//        return new ResponseEntity<>("200", HttpStatus.OK);
//    }

//    @GetMapping("api/qrcode")
//    public ResponseEntity<BufferedImage> getImage() {
//        BufferedImage bufferedImage = createImage();
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_PNG)
//                .body(bufferedImage);
//    }

//    @GetMapping("api/code")
//    public ResponseEntity<?> getImage2(@RequestParam(required = false) Integer size,
//                                       @RequestParam(required = false) String type) {
//
//
//        if (size == null && type == null) {
//            return new ResponseEntity<>("200", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("400", HttpStatus.BAD_REQUEST);
//    }

    @GetMapping("api/qrcode")
    public ResponseEntity<?> getImage(@RequestParam(required = false) Integer size,
                                      @RequestParam(required = false) String type) {

        BufferedImage bufferedImage = createImage();

        if (size == null || type == null) {

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(bufferedImage);

        } else if (size < 150 || size > 350) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, "Image size must be between 150 and 350 pixels");

        } else if (!type.matches(".*png|.*jpeg|.*gif")) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, "Only png, jpeg and gif image types are supported");

        } else if ((size > 150 && size <= 350) && type.matches(".*png|.*jpeg|.*gif")){
            BufferedImage picture = createImage(size);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/" + type.toUpperCase()))
                    .body(picture);
        }
        BufferedImage picture = createImage(size);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("image/" + type.toUpperCase()))
                .body(picture);
    }

    private static BufferedImage createImage(int size2) {

        BufferedImage image = new BufferedImage(size2, size2, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, size2, size2);
        g.dispose();

        return image;
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
