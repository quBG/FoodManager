package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.foodmanager.R;

import java.util.Objects;

public class MyFridge extends AppCompatActivity {
    private LinearLayout listItem;
    private Dialog addingProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fridge);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.myFridgeFrameName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listItem = findViewById(R.id.listItem);
        addingProduct = new Dialog(this);

        final Button buttonSelect = findViewById(R.id.selectProducts);
        buttonSelect.setOnClickListener(view -> {
            //SELECT PRODUCTS
        });

        final View buttonAdd = findViewById(R.id.addProduct);
        buttonAdd.setOnClickListener(view -> {
            showMenu();
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

    private void showMenu() {
        addingProduct.setContentView(R.layout.popup_menu_adding_product);
        addingProduct.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        EditText text = addingProduct.findViewById(R.id.productName);

        Button apply = addingProduct.findViewById(R.id.applyName);
        apply.setOnClickListener((view) -> {
            String productName = text.getText().toString();
            buildElement(productName);
        });
    }

    private void buildElement(String name) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(Gravity.CENTER);

        TextView textView = new TextView(this);
        textView.setBackgroundColor(0xffe8eaf6);
        textView.setTextColor(0xff5c6bc0);
        textView.setAllCaps(true);
        textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        textView.setText("Hello Android!");
        linearLayout.addView(textView);
        listItem.addView(linearLayout);
    }
}