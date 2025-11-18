package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DishListAdapter extends ArrayAdapter<Dish> {

    private Context context;
    private int resource;
    private List<Dish> dishes;

    public DishListAdapter(@NonNull Context context, int resource, @NonNull List<Dish> dishes) {
        super(context, resource, dishes);
        this.context = context;
        this.resource = resource;
        this.dishes = dishes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(resource, parent, false);
        }

        ImageView imgDish = row.findViewById(R.id.imgDish);
        TextView txtDishName = row.findViewById(R.id.txtDishName);
        TextView txtDishDesc = row.findViewById(R.id.txtDishDesc);
        TextView txtDishPrice = row.findViewById(R.id.txtDishPrice);

        Dish dish = dishes.get(position);
        imgDish.setImageResource(dish.getImageResId());
        txtDishName.setText(dish.getName());
        txtDishDesc.setText(dish.getDescription());
        txtDishPrice.setText(String.format("%.0f VND", dish.getPrice()));

        return row;
    }
}
