package com.foodmanager.recipes.storage;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StorageSerializer extends Serializer {
    private ObjectOutputStream file;
    private String fileName;
    private final String path;

    public StorageSerializer(String serializationFileName) {
        path = Environment.getDataDirectory().getAbsolutePath();
        fileName = serializationFileName;
    }

    @Override
    public String getFileName() {
        try {
            if (fileName != null)
                return fileName;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new NullPointerException();
        }
        return null;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void setFileName(String name) {
        this.fileName=name;
    }

    @Override
    public void deleteFile() {
        try {
            file.close();
            File temp = new File(path, getFileName());
            temp.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serialize(Object object) {
        try {
            if (getFileName() != null) {
                file = new ObjectOutputStream(new FileOutputStream(path + getFileName()));
                file.writeObject(object);
                file.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new NullPointerException("Name is not set on serialization");
        }
    }

    @Override
    public Object deserialize() {
        try {
            if (getFileName() != null) {
                ObjectInputStream stream = new ObjectInputStream(new FileInputStream(
                        path + getFileName()));
                return stream.read();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new NullPointerException("Name is not set on serialization");
        }
        return null;
    }
}
