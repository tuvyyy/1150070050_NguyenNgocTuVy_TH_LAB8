package com.example.a1150070050_nguyenngoctuvy_th_lab8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a1150070050_nguyenngoctuvy_th_lab8.R;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodCrudActivity extends AppCompatActivity {

    ListView lvFoodCrud;
    ArrayList<Dish> dishes;
    DishListAdapter adapter;
    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_crud);

        lvFoodCrud = findViewById(R.id.lvFoodCrud);

        dishes = new ArrayList<>();
        // Dữ liệu ban đầu
        dishes.add(new Dish(R.drawable.ic_food_1, "Phở bò", "Phở bò Hà Nội", 45000));
        dishes.add(new Dish(R.drawable.ic_food_2, "Bún chả", "Bún chả truyền thống", 40000));
        dishes.add(new Dish(R.drawable.ic_food_1, "Cơm tấm", "Cơm tấm sườn bì chả", 50000));

        adapter = new DishListAdapter(this, R.layout.row_dish_list, dishes);
        lvFoodCrud.setAdapter(adapter);

        // Đăng ký ContextMenu cho ListView
        registerForContextMenu(lvFoodCrud);

        lvFoodCrud.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                return false; // để onCreateContextMenu được gọi
            }
        });
    }

    // Tạo options menu (nút Thêm trên toolbar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_food_crud, menu);
        return true;
    }

    // Xử lý chọn item trên options menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            showAddDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Tạo ContextMenu cho ListView (Sửa / Xóa)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_dish, menu);
    }

    // Xử lý chọn item trong ContextMenu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_edit) {
            showEditDialog(selectedPosition);
            return true;
        }

        if (id == R.id.action_delete) {
            dishes.remove(selectedPosition);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã xóa món ăn", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm món ăn");

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_dish, null);
        builder.setView(dialogView);

        EditText edtName = dialogView.findViewById(R.id.edtDishName);
        EditText edtDesc = dialogView.findViewById(R.id.edtDishDesc);
        EditText edtPrice = dialogView.findViewById(R.id.edtDishPrice);

        builder.setPositiveButton("Lưu", (dialog, which) -> {
            String name = edtName.getText().toString().trim();
            String desc = edtDesc.getText().toString().trim();
            String priceStr = edtPrice.getText().toString().trim();

            if (name.isEmpty() || priceStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ tên và giá", Toast.LENGTH_SHORT).show();
                return;
            }

            double price = Double.parseDouble(priceStr);
            // Tạm thời dùng 1 hình mặc định
            Dish dish = new Dish(R.drawable.ic_food_1, name, desc, price);
            dishes.add(dish);
            adapter.notifyDataSetChanged();
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

    private void showEditDialog(int position) {
        Dish dish = dishes.get(position);

        AlertDialog.Builder builder = null;
        try {
            builder = new AlertDialog.Builder(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        builder.setTitle("Sửa món ăn");


        View dialogView = getLayoutInflater().inflate(R.layout.dialog_dish, null);
        builder.setView(dialogView);

        EditText edtName = dialogView.findViewById(R.id.edtDishName);
        EditText edtDesc = dialogView.findViewById(R.id.edtDishDesc);
        EditText edtPrice = dialogView.findViewById(R.id.edtDishPrice);

        edtName.setText(dish.getName());
        edtDesc.setText(dish.getDescription());
        edtPrice.setText(String.valueOf(dish.getPrice()));

        builder.setPositiveButton("Lưu", (dialog, which) -> {
            String name = edtName.getText().toString().trim();
            String desc = edtDesc.getText().toString().trim();
            String priceStr = edtPrice.getText().toString().trim();

            if (name.isEmpty() || priceStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ tên và giá", Toast.LENGTH_SHORT).show();
                return;
            }

            double price = Double.parseDouble(priceStr);
            dish.setName(name);
            dish.setDescription(desc);
            dish.setPrice(price);

            adapter.notifyDataSetChanged();
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }
}
