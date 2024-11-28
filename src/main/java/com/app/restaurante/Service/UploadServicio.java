package com.app.restaurante.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class UploadServicio {

    private final String url = "src/main/resources/static/upload/empleados/";

    public String saveUpload(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            String encode = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), StandardCharsets.UTF_8);
            Path path = Paths.get(url + encode);
            Files.write(path, bytes);
            return encode;
        }
        return null;
    }

    public void deleteUpload(String nombre) {
        File file = new File(url + nombre);
        file.delete();
    }
}
