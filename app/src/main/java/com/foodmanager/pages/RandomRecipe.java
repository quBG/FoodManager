package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.foodmanager.MainActivity;
import com.foodmanager.R;

public class RandomRecipe extends AppCompatActivity implements Temp {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_recipe);
    }

    @Override
    public void backButton(View view) {
        onBackPressed();
    }
}