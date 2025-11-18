package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomOSListActivity extends AppCompatActivity {

    ListView lvOS;
    TextView txtSelectedOS;
    ArrayList<Product> products;
    MyProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_os_list);

        lvOS = findViewById(R.id.lvOS);
        txtSelectedOS = findViewById(R.id.txtSelectedOS);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.ic_wp, "Android", "Hệ điều hành mã nguồn mở"));
        products.add(new Product(R.drawable.ic_food_1, "iOS", "Hệ điều hành của Apple"));
        products.add(new Product(R.drawable.ic_wp, "Windows Phone", "Hệ điều hành của Microsoft"));

        adapter = new MyProductAdapter(this, R.layout.row_os_product, products);
        lvOS.setAdapter(adapter);

        lvOS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p = products.get(position);
                txtSelectedOS.setText("Bạn chọn: " + p.getTitle());
            }
        });
    }
}
