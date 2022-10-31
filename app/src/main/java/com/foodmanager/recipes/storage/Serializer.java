package com.foodmanager.recipes.storage;

import java.io.Serializable;

public abstract class Serializer implements Serializable {
    public abstract String getPath();
    public abstract String getFileName();
    public abstract void setFileName(String name);
    public abstract void deleteFile();

    public abstract void serialize(Object object);
    public abstract Object deserialize();
}
