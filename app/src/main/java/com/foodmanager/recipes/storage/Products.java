package com.foodmanager.recipes.storage;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<String> products = new ArrayList<>();

    public boolean productIsAdded(String name) {
        for (String product : products){
            if (product.contains(name)){
                return true;
            }
        }
        return false;
    }

    public void addProduct(String name) {
        products.add(name);
    }

    public void deleteProduct(String name) {
        products.add(name);
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }
}
