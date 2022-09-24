package com.foodmanager.recipes.loaders;

import com.foodmanager.api.Connector;
import com.foodmanager.recipes.builders.RecipeBuiler;

public class ProductsLoader {
    private RecipeBuiler builer;
    private Connector connector;

    public ProductsLoader() {
        builer = new RecipeBuiler();
        connector = new Connector();
    }

    private StringBuilder createProduct(String productName) {
        return connector.request("https://api.edamam.com/auto-complete?app_id=df10d32c&app_key=" +
                "3964b0d86f9af555c12097b9aa5ee0bc&q=" + productName);
    }
}
