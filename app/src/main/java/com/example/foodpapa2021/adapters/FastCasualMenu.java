package com.example.foodpapa2021.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodpapa2021.CategoryPage;
import com.example.foodpapa2021.FoodDetail;
import com.example.foodpapa2021.R;
import com.example.foodpapa2021.RestaurantPage;
import com.example.foodpapa2021.realm.CategoryList;
import com.example.foodpapa2021.realm.FoodList_fc;
import com.example.foodpapa2021.realm.RestaurantList;

import javax.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class FastCasualMenu extends RealmRecyclerViewAdapter<FoodList_fc, FastCasualMenu.ViewHolder> {
    RestaurantPage activity;

    public FastCasualMenu(RestaurantPage activity, @Nullable OrderedRealmCollection<FoodList_fc> data, boolean autoUpdate){
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        ImageView img;
        ConstraintLayout fcObj;

        public ViewHolder(@NonNull View food_fcView){
            super(food_fcView);

            price = food_fcView.findViewById(R.id.food_obj_price);
            name = food_fcView.findViewById(R.id.food_obj_name);
            img = food_fcView.findViewById(R.id.food_img_img);
            fcObj = food_fcView.findViewById(R.id.food_obj);
        }
    }

    @NonNull
    @Override
    public FastCasualMenu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.food_objects, parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FastCasualMenu.ViewHolder holder, int position) {
        FoodList_fc fc = getItem(position);

        holder.name.setText(fc.getFc_name());
        holder.price.setText(String.valueOf(fc.getFc_price()));

        //Fast Food
        if (fc.getFc_name().equals("Baby Back Ribs")) {
            holder.img.setImageResource(R.drawable.foodlist_img_outback_ribs);
        } else if (fc.getFc_name().equals("Caesar Salad")) {
            holder.img.setImageResource(R.drawable.foodlist_img_outback_salad);
        } else if (fc.getFc_name().equals("Iced Tea")) {
            holder.img.setImageResource(R.drawable.foodlist_img_icedtea);
        } else if (fc.getFc_name().equals("Spaghetti")) {
            holder.img.setImageResource(R.drawable.foodlist_img_outback_pasta);
        }

        holder.fcObj.setTag(fc);
        holder.fcObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.fcObj((FoodList_fc) v.getTag());
            }
        });
    }
}
