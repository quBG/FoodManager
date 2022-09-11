package com.foodmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.foodmanager.pages.*;
import com.foodmanager.recipes.connection.Connector;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connector connector = new Connector();
    }

    public void toMyFridge(View view) {
        Intent intent = new Intent(this, MyFridge.class);
        startActivity(intent);
    }

    public void toCategories(View view) {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    public void toSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    public void toRandomRecipe(View view) {
        Intent intent = new Intent(this, RandomRecipe.class);
        startActivity(intent);
    }

    public void toStory(View view) {
        Intent intent = new Intent(this, Story.class);
        startActivity(intent);
    }

    public void toStatistics(View view) {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);
    }
}