package com.example.demo.service.impl;

import com.cloudinary.Cloudinary;
import com.example.demo.service.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadImpl implements FileUpload {

    private final Cloudinary cloudinary;
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        Map<String, Object> uploadParams = new HashMap<>();
        uploadParams.put("folder", "test"); // Specify your folder here
        uploadParams.put("public_id", UUID.randomUUID().toString());

        return cloudinary.uploader().upload(file.getBytes(), uploadParams)
                .get("url").toString();
    }

}
