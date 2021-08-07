package com.example.foodpapa2021.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
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

public class MilkteaMenu extends RealmRecyclerViewAdapter<FoodList_m, MilkteaMenu.ViewHolder> {
    FoodDetail activity;

    public MilkteaMenu(FoodDetail activity, @Nullable OrderedRealmCollection<FoodList_m> data, boolean autoUpdate) {
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView price;
        TextView name;
        ImageView img;
        ConstraintLayout mObj;

        public ViewHolder(@Nonnull View food_mView){
            super (food_mView);

            price = food_mView.findViewById(R.id.food_obj_price);
            name = food_mView.findViewById(R.id.food_obj_name);
            img = food_mView.findViewById(R.id.food_img_img);
            mObj = food_mView.findViewById(R.id.food_obj);
        }
    }

    @Nonnull
    @Override
    public MilkteaMenu.ViewHolder onCreateViewHolder (@Nonnull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.food_objects, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@Nonnull MilkteaMenu.ViewHolder holder, int position){
        FoodList_m m = getItem(position);

        holder.name.setText(m.getM_name());
        holder.price.setText(String.valueOf(m.getM_price()));

        if (m.getM_name().equals("Classic with Pearls"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_pearl);
        }
        else if (m.getM_name().equals("Classic"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_classic);
        }
        else if (m.getM_name().equals("Brown Sugar Milk Tea"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_sugar);
        }
        else if (m.getM_name().equals("Black Iced Tea"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_black);
        }

        holder.mObj.setTag(m);
        holder.mObj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity.mObj((FoodList_m) v.getTag());
            }
        });
    }
}




