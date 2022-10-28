package com.foodmanager.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.MarginLayoutParams;

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

    private Dialog createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.popup_menu_adding_product, null));
        return builder.create();
    }

    private void showMenu() {
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
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(Gravity.START);
        MarginLayoutParams params = (MarginLayoutParams) linearLayout.getLayoutParams();
        params.setMargins(45, 20, 45, 10);
        linearLayout.setLayoutParams(params);

        TextView textView = new TextView(this);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        textView.setText(name);
        textView.setTextSize(22);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(textView.getLayoutParams());
        textParams.setMargins(3, 3, 3, 3);
        textView.setLayoutParams(textParams);

        linearLayout.addView(textView);
        linearLayout.setBackground(getDrawable(R.drawable.rectangle));
        listItem.addView(linearLayout, 0);
    }
}