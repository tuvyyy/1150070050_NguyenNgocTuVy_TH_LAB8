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

public class MyProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private int resource;
    private List<Product> objects;

    public MyProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(resource, parent, false);
        }

        ImageView imgRow = row.findViewById(R.id.imgRow);
        TextView txtTitle = row.findViewById(R.id.txtTitle);
        TextView txtContent = row.findViewById(R.id.txtContent);

        Product p = objects.get(position);

        imgRow.setImageResource(p.getImageResId());
        txtTitle.setText(p.getTitle());
        txtContent.setText(p.getContent());

        return row;
    }
}
