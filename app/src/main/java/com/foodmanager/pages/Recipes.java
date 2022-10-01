package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.foodmanager.R;

public class Recipes extends AppCompatActivity implements Temp {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }

    @Override
    public void backButton(View view) {
        onBackPressed();
    }
}