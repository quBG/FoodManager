package com.foodmanager.recipes.storage;

import android.content.Context;

import java.io.Serializable;

public abstract class Serializer implements Serializable {
    public abstract String getFileName();
    public abstract void setFileName(String name);
    public abstract void deleteFile(Context context);
    public abstract void serialize(Object object, Context context);
    public abstract Object deserialize(Context context);
}
