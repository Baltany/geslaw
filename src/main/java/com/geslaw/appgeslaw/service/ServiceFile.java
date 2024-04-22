package com.geslaw.appgeslaw.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServiceFile {
    private final String UPLOAD_DIR = "/docs/facturas";

    public String guardarFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío");
        }

        String originalFileName = file.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

        Path uploadPath = Paths.get(UPLOAD_DIR, uniqueFileName);
        Files.createDirectories(uploadPath.getParent());

        file.transferTo(uploadPath.toAbsolutePath().normalize().toFile());

        return uniqueFileName;
    }
}
