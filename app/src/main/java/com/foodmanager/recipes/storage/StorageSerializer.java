package com.foodmanager.recipes.storage;

import java.io.ObjectInputStream;

public class StorageSerializer extends Serializer {
    private String fileName;

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String name) {
        this.fileName=name;
    }

    @Override
    public void deleteFile() {

    }

    @Override
    public Boolean serialize(Object object) {
        return null;
    }

    @Override
    public ObjectInputStream deserialize() {
        return null;
    }
}
