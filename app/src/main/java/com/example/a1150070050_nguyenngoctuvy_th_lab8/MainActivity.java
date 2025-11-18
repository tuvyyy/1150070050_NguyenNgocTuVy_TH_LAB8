package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSimpleList, btnCustomOS, btnFoodList, btnFoodGrid, btnFoodCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleList = findViewById(R.id.btnSimpleList);
        btnCustomOS = findViewById(R.id.btnCustomOS);
        btnFoodList = findViewById(R.id.btnFoodList);
        btnFoodGrid = findViewById(R.id.btnFoodGrid);
        btnFoodCrud = findViewById(R.id.btnFoodCrud);

        btnSimpleList.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SimpleListActivity.class)));

        btnCustomOS.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CustomOSListActivity.class)));

        btnFoodList.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FoodListActivity.class)));

        btnFoodGrid.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FoodGridActivity.class)));

        btnFoodCrud.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FoodCrudActivity.class)));
    }
}
