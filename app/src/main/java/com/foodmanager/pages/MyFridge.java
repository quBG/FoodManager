package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.foodmanager.R;

import java.util.Objects;

public class MyFridge extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fridge);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.myFridgeFrameName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button buttonSelect = findViewById(R.id.selectProducts);
        buttonSelect.setOnClickListener(view -> {
            //SELECT PRODUCTS
        });

        final View buttonAdd = findViewById(R.id.addProduct);
        buttonAdd.setOnClickListener(view -> {
            //ADDING PRODUCT
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}