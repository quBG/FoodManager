package com.foodmanager.recipes.loaders;

import android.util.Log;

import com.foodmanager.api.Connector;

public class ProductsLoader {
    private final Connector connector = new Connector();

    public String createProduct(String productName) {
        StringBuilder result = connector.request(
                "https://api.edamam.com/auto-complete?app_id=df10d32c&app_key=" +
                "3964b0d86f9af555c12097b9aa5ee0bc&q=" + productName);

        if (result == null) {
            Log.e("ProductsLoader", "The result is null, check the operation of the connector");
            throw new NullPointerException();
        }

        return result.toString();
    }
}
