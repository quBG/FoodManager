package com.foodmanager.recipes.builders;

import android.media.Image;

import com.foodmanager.recipes.Recipe;

public interface Builder {
    void setImage(Image image);
    void setDescription(String text);
    void setName(String name);
    void setCategories(String name);
    void setCalories(int number);

    Recipe getResult();
}
