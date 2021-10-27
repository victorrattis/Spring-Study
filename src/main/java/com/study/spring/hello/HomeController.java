package com.study.spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public ResponseEntity<String> upload(
            @RequestParam("file") MultipartFile file
    ) {
        boolean result = fileService.uploadFile(file);
        if (result) {
            return ResponseEntity.ok().body("SUCCESS");
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body("ERROR");
        }
    }

    @GetMapping("list")
    public ResponseEntity<List<String>> list() {
        return ResponseEntity.ok().body(fileService.getFileList());
    }
}


