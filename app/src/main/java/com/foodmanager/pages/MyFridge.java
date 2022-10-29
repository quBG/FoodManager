package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.foodmanager.R;
import com.foodmanager.recipes.loaders.ProductsLoader;

import java.util.Objects;

public class MyFridge extends AppCompatActivity {
    private LinearLayout listItem;
    private Dialog dialogAdding;
    private final ProductsLoader productLoader = new ProductsLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fridge);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.myFridgeFrameName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listItem = findViewById(R.id.listItem);
        dialogAdding = createDialog();

        final Button buttonSelect = findViewById(R.id.selectProducts);
        buttonSelect.setOnClickListener(view -> {
            //SELECT PRODUCTS
        });

        final View buttonAdd = findViewById(R.id.addProduct);
        buttonAdd.setOnClickListener(view -> {
            showDialog();
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

    private Dialog createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.popup_menu_adding_product, null));
        return builder.create();
    }

    private void showDialog() {
        dialogAdding.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogAdding.show();

        Button apply = dialogAdding.findViewById(R.id.applyName);
        apply.setOnClickListener((view) -> {
            apply.setClickable(false);
            EditText text = dialogAdding.findViewById(R.id.productName);
            String name = text.getText().toString();
            dialogAdding.hide();
            String product = productLoader.load(name);
            if (product != null)
                buildElement(product);
        });
    }

    private void buildElement(String name) {
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout viewProduct = (LinearLayout) inflater.
                inflate(R.layout.product_for_fridge, null);
        listItem.addView(viewProduct, 0);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewProduct.getLayoutParams();
        params.setMargins(0,0,0,10);
        viewProduct.setLayoutParams(params);

        TextView textView = findViewById(R.id.nameProduct);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        textView.setText(name);

        View deleteButton = findViewById(R.id.deleteElement);
        deleteButton.setOnClickListener(view -> {
            viewProduct.removeAllViews();
            listItem.removeViewInLayout(viewProduct);
        });
    }
}