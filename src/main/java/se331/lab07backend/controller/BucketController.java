package se331.lab07backend.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import se331.lab07backend.util.CloudStorageHelper;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file, "se331imageupload.appspot.com"));
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image") MultipartFile file) throws IOException, ServletException{
        return ResponseEntity.ok(this.cloudStorageHelper.getStorageFileDTO(file, "se331imageupload.appspot.com"));
    }
}
