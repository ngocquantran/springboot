package com.example.itviec.service;


import com.example.itviec.exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;

    public void uploadFile(MultipartFile file){
        if (file.isEmpty()){
            throw new StorageException("Failed to store emmty file");
        }
        String fileName= file.getOriginalFilename();
        try{
            var is=file.getInputStream();
            Files.copy(is, Paths.get(path+fileName), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            var msg=String.format("Fialed to store file %s",fileName);
            throw new StorageException(msg,e);
        }

    }
}
