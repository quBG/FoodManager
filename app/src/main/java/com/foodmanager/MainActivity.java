package com.foodmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.foodmanager.api.Connector;
import com.foodmanager.pages.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void backButton(){
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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