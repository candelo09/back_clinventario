package com.clsystem.clinventario.services;

import com.clsystem.clinventario.repository.IStorageRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StorageService implements IStorageRepository {
    @Override
    public String store(InputStream inputStream, long size, String contentType, String originalFileName) {
        return inputStream.toString();
    }
}
