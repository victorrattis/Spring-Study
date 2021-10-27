package com.study.spring.hello;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorage {
    boolean saveFile(MultipartFile file, String userId);
    List<String> getFiles(String userId);
}
