package com.study.spring.hello;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component("FileStorage")
public class InternalFileStorage  implements  FileStorage {
    @Override
    public boolean saveFile(MultipartFile file, String userId) {
        try {
            Path rootLocation = Paths.get("upload-files/" + userId);

            try {
                Files.createDirectories(rootLocation);
            }
            catch (IOException e) {
                throw new IOException("Could not initialize storage", e);
            }

            Path destinationFile = rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(rootLocation.toAbsolutePath())) {
                System.out.println("Cannot store file outside current directory.");
                return false;
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to store file.");
        }

        return false;
    }

    @Override
    public List<String> getFiles(String userId) {
        File f = new File("upload-files/" + userId);
        return f.list() != null ? Arrays.asList(f.list()) : Collections.emptyList();
    }
}
