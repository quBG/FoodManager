package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.foodmanager.R;

public class MyFridge extends AppCompatActivity implements Temp {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fridge);
    }

    public void outputOfProducts(View view) {
        Intent intent = new Intent(this, Recipes.class);
        startActivity(intent);
    }

    @Override
    public void backButton(View view) {
        onBackPressed();
    }
}