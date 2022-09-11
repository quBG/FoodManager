package com.foodmanager.recipes;

import android.media.Image;

public class Recipe {
    private Image image;
    private String description;
    private String name;
    private String categories;
    private int calories;

    public Recipe(Image image, String description, String name, String categories, int calories) {
        this.image = image;
        this.description = description;
        this.name = name;
        this.categories = categories;
        this.calories = calories;
    }
}
