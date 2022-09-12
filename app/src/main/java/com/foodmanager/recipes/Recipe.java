package com.foodmanager.recipes;

import android.media.Image;

import java.util.List;

public class Recipe {
    private List<String> ingradients;
    private Image image;
    private String description;
    private String name;
    private String categories;
    private int calories;

    public Recipe(Image image, String description, String name, String categories, int calories, List<String> ingradients) {
        this.image = image;
        this.description = description;
        this.name = name;
        this.categories = categories;
        this.calories = calories;
        this.ingradients = ingradients;
    }
}
