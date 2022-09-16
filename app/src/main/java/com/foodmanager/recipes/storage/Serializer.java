package com.foodmanager.recipes.storage;

import java.io.ObjectInputStream;
import java.io.Serializable;

public abstract class Serializer implements Serializable {
    public abstract String getFileName();
    public abstract void setFileName(String name);
    public abstract void deleteFile();

    public abstract Boolean serialize(Object object);
    public abstract ObjectInputStream deserialize();
}
