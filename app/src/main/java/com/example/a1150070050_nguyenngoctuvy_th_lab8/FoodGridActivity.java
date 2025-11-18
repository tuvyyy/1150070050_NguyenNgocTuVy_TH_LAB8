package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodGridActivity extends AppCompatActivity {

    GridView gvFood;
    ArrayList<Dish> dishes;
    DishGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_grid);

        gvFood = findViewById(R.id.gvFood);

        dishes = new ArrayList<>();
        dishes.add(new Dish(R.drawable.ic_food_1, "Phở bò", "Phở bò Hà Nội", 45000));
        dishes.add(new Dish(R.drawable.ic_food_2, "Bún chả", "Bún chả truyền thống", 40000));
        dishes.add(new Dish(R.drawable.ic_food_1, "Cơm tấm", "Cơm tấm sườn bì chả", 50000));
        dishes.add(new Dish(R.drawable.ic_food_2, "Bánh mì", "Bánh mì thịt", 20000));

        adapter = new DishGridAdapter(this, R.layout.item_dish_grid, dishes);
            gvFood.setAdapter(adapter);

        gvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Dish d = dishes.get(position);
                Toast.makeText(FoodGridActivity.this,
                        d.getName() + " - " + d.getPrice() + " VND",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
