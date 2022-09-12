package com.foodmanager.recipes.builders;

import android.media.Image;

import com.foodmanager.recipes.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeBuiler implements Builder {
    private Image image;
    private String description;
    private String name;
    private String categories;
    private int calories;
    private List<String> ingradients = new ArrayList<>();

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void setDescription(String text) {
        this.description = text;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCategories(String name) {
        this.categories = name;
    }

    @Override
    public void setCalories(int number) {
        this.calories = number;
    }

    @Override
    public void setProducts(List<String> ingredients) {
        this.ingradients = ingredients;
    }

    @Override
    public Recipe getResult() {
        return new Recipe(image, description, name, categories, calories, ingradients);
    }
}
