package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.foodmanager.R;

public class Search extends AppCompatActivity implements Temp {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void backButton(View view) {
        onBackPressed();
    }
}