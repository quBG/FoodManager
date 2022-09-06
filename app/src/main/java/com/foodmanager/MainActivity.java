package com.foodmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.foodmanager.pages.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toMyFridge(View view) {
        Intent intent = new Intent(this, myFridge.class);
        startActivity(intent);
    }

    public void toCategories(View view) {
        Intent intent = new Intent(this, categories.class);
        startActivity(intent);
    }

    public void toSearch(View view) {
        Intent intent = new Intent(this, search.class);
        startActivity(intent);
    }

    public void toRandomRecipe(View view) {
        Intent intent = new Intent(this, randomRecipe.class);
        startActivity(intent);
    }

    public void toStory(View view) {
        Intent intent = new Intent(this, story.class);
        startActivity(intent);
    }

    public void toStatistics(View view) {
        Intent intent = new Intent(this, statistics.class);
        startActivity(intent);
    }
}