package com.myapplicationdev.android.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<Food> foodArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize List View Components
        listView = findViewById(R.id.list_view_food);
        listView.setOnItemClickListener(this::onItemClick);
        foodArray = new ArrayList<>();
        arrayAdapter = new FoodAdapter(this, R.layout.row, foodArray);

        // Add Items
        foodArray.add(new Food("Ah Lat Coffee", false));
        foodArray.add(new Food("Rocky Choc", true));
        foodArray.add(new Food("Kid Cat Choc", true));

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Food selFood = foodArray.get(position);
        Toast.makeText(this, selFood.getName() + " Star: " + selFood.isStar() , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("isStar", selFood.isStar());
        startActivity(intent);
    }

}