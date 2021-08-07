package com.example.foodpapa2021.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodpapa2021.FoodDetail;
import com.example.foodpapa2021.R;
import com.example.foodpapa2021.RestaurantPage;
import com.example.foodpapa2021.realm.CategoryList;
import com.example.foodpapa2021.realm.FoodList;
import com.example.foodpapa2021.realm.FoodList_m;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class MilkteaMenu extends RealmRecyclerViewAdapter<FoodList_m, FastFoodMenu.ViewHolder> {

    FoodDetail activity;

    public FastFoodMenu(FoodDetail activity, @Nullable OrderedRealmCollection<FoodList_m> data, boolean autoUpdate) {
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView food_obj_name;
        TextView food_obj_price;
        ImageView food_img_img;

        public ViewHolder(@Nonnull View food_ffView){
            super (food_ffView);

            price = categoryView.findViewById(R.id.food_obj_price);
            name = categoryView.findViewById(R.id.food_obj_name);
            img = categoryView.findViewById(R.id.food_img_img);
        }
    }

    @Nonnull
    @Override
    public FastFoodMenu.ViewHolder onCreateViewHolder (@Nonnull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.category_objects, parent, false);

        FastFoodMenu.ViewHolder vh = new FastFoodMenu.ViewHolder(v);
        return vh
    }

    @Override
    public void onBindViewHolder(@Nonnull FastFoodMenu.ViewHolder holder, int position){
        FoodList_m cat = getItem(position);

        holder.name.setText(m.getM_name());
        holder.price.setText(m.getM_price());

        if (m.getM_name().equals("CoCo Fresh Tea & Juice"))
        {
            holder.img.setImageResource(R.drawable.coco_logo);
        }
        else if (m.getM_name().equals("Gongcha"))
        {
            holder.img.setImageResource(R.drawable.gongcha_logo);
        }
        else if (m.getM_name().equals("Macao Imperial Tea"))
        {
            holder.img.setImageResource(R.drawable.macao_logo);
        }
        else if (m.getM_name().equals("Serenitea"))
        {
            holder.img.setImageResource(R.drawable.serenitea_logo);
        }
        else if (m.getM_name().equals("Tiger Sugar"))
        {
            holder.img.setImageResource(R.drawable.tigersugar_logo);
        }

        holder.mobj.setTag(m);
        holder.mobj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity.mObj((FoodList_m) v.getTag());
            }
        });
    }
}




