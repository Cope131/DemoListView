package com.myapplicationdev.android.demolistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private ArrayList<Food> foodArray;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(@NonNull Context context, int resource, ArrayList<Food> foodArray) {
        super(context, resource, foodArray);
        this.foodArray = foodArray;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvFoodName = rowView.findViewById(R.id.tv_food_name);
        ivStar = rowView.findViewById(R.id.iv_star);

        Food curFood = foodArray.get(position);

        tvFoodName.setText(curFood.getName());
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.nostar);
        if (curFood.isStar())
            drawable = ContextCompat.getDrawable(context, R.drawable.star);
        ivStar.setImageDrawable(drawable);

        return rowView;

    }
}
