package com.foodmanager.recipes.storage;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StorageSerializer extends Serializer {
    private String fileName;

    public StorageSerializer(String serializationFileName) {
        fileName = serializationFileName;
    }

    @Override
    public void deleteFile(Context context) {
        context.deleteFile(fileName);
    }

    @Override
    public void serialize(Object object, Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Object deserialize(Context context) {
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = (Object) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return object;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void setFileName(String name) {
        this.fileName=name;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
