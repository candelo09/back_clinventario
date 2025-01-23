package com.clsystem.clinventario.repository;

import java.io.InputStream;

public interface IStorageRepository {

    public String store(InputStream inputStream, long size, String contentType, String originalFileName);
}
