package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SimpleListActivity extends AppCompatActivity {

    ListView lvDevices;
    TextView txtSelected;
    String[] devices = {"Android", "iOS", "Windows Phone", "BlackBerry", "Symbian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        lvDevices = findViewById(R.id.lvDevices);
        txtSelected = findViewById(R.id.txtSelected);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                devices
        );
        lvDevices.setAdapter(adapter);

        lvDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = devices[position];
                txtSelected.setText("Bạn chọn: " + value);
            }
        });
    }
}
