package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishGridAdapter extends BaseAdapter {

    private Context context;
    private int resource;
    private List<Dish> dishes;

    public DishGridAdapter(Context context, int resource, List<Dish> dishes) {
        this.context = context;
        this.resource = resource;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int position) {
        return dishes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem = convertView;
        if (gridItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            gridItem = inflater.inflate(resource, parent, false);
        }

        ImageView imgDish = gridItem.findViewById(R.id.imgDishGrid);
        TextView txtDishName = gridItem.findViewById(R.id.txtDishNameGrid);
        TextView txtDishPrice = gridItem.findViewById(R.id.txtDishPriceGrid);

        Dish dish = dishes.get(position);
        imgDish.setImageResource(dish.getImageResId());
        txtDishName.setText(dish.getName());
        txtDishPrice.setText(String.format("%.0f VND", dish.getPrice()));

        return gridItem;
    }
}
