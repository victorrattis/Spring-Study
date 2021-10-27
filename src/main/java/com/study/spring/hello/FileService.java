package com.study.spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {
    @Autowired
    public FileStorage fileStorage;

    public boolean uploadFile(MultipartFile file) {
        // logica de verificar se o ususario limite com plano;
//        int number = fileStorage.getFileNumberByUser(userId);
//        int capacity = fileStorage.getByteSavedFile(userId);


//        if (number >)

        fileStorage.saveFile(file, "0001");

        return false;
    }

    public List<String> getFileList() {
        return fileStorage.getFiles("0001");
    }
}
