package com.foodmanager.recipes.builders;

import android.media.Image;

import com.foodmanager.recipes.Recipe;

public class RecipeBuiler implements Builder {
    private Image image;
    private String description;
    private String name;
    private String categories;
    private int calories;

    @Override
    public void setImage(Image image) {
        this.image=image;
    }

    @Override
    public void setDescription(String text) {
        this.description=text;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setCategories(String name) {
        this.categories=name;
    }

    @Override
    public void setCalories(int number) {
        this.calories=number;
    }

    @Override
    public Recipe getResult() {
        return new Recipe(image, description, name, categories, calories);
    }
}
