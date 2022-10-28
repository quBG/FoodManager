package com.foodmanager.recipes.loaders;

import android.util.Log;

import com.foodmanager.api.Connector;

import org.json.JSONArray;
import org.json.JSONException;

public class ProductsLoader {
    private final Connector connector = new Connector();

    /**
     * The method will be used when we have a internet connection.
     * @param productName must be without errors, the product can be anything but only edible.
     * @return String gives us the name of the product if it exists
     * in the database choosing from a list of similar ones.
     * */
    public String load(String productName) {
        String array = connector.request(
                "https://api.edamam.com/auto-complete?app_id=df10d32c&app_key=" +
                "3964b0d86f9af555c12097b9aa5ee0bc&q=" + productName);

        if (array.equals("")) {
            Log.e("ProductsLoader", "The result is null, check the operation of the connector");
            throw new NullPointerException();
        }

        try {
            return new JSONArray(array).get(0).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
