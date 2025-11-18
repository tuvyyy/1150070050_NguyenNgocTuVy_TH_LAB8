package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    ListView lvFood;
    ArrayList<Dish> dishes;
    DishListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        lvFood = findViewById(R.id.lvFood);

        dishes = new ArrayList<>();
        // Ví dụ một số món ăn
        dishes.add(new Dish(R.drawable.ic_food_1, "Phở bò", "Phở bò Hà Nội", 45000));
        dishes.add(new Dish(R.drawable.ic_food_2, "Bún chả", "Bún chả truyền thống", 40000));
        dishes.add(new Dish(R.drawable.ic_food_1, "Cơm tấm", "Cơm tấm sườn bì chả", 50000));
        dishes.add(new Dish(R.drawable.ic_food_2, "Bánh mì", "Bánh mì thịt", 20000));

        adapter = new DishListAdapter(this, R.layout.row_dish_list, dishes);
        lvFood.setAdapter(adapter);
    }
}
