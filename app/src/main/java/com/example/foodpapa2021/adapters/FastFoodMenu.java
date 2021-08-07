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
import com.example.foodpapa2021.realm.FoodList_ff;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class FastFoodMenu extends RealmRecyclerViewAdapter<FoodList_ff, FastFoodMenu.ViewHolder> {
    FoodDetail activity;

    public FastFoodMenu(FoodDetail activity, @Nullable OrderedRealmCollection<FoodList_ff> data, boolean autoUpdate) {
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView price;
        TextView name;
        ImageView img;
        ConstraintLayout ffObj;

        public ViewHolder(@Nonnull View food_ffView){
            super (food_ffView);

            price = food_ffView.findViewById(R.id.food_obj_price);
            name = food_ffView.findViewById(R.id.food_obj_name);
            img = food_ffView.findViewById(R.id.food_img_img);
            ffObj = food_ffView.findViewById(R.id.food_obj);
        }
    }

    @Nonnull
    @Override
    public FastFoodMenu.ViewHolder onCreateViewHolder (@Nonnull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.food_objects, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@Nonnull FastFoodMenu.ViewHolder holder, int position){
        FoodList_ff ff = getItem(position);

        holder.name.setText(ff.getFf_name());
        holder.price.setText(ff.getFf_price());

        if (ff.getFf_name().equals("1-pc. Fried Chicken"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_chicken);
        }
        else if (ff.getFf_name().equals("1-pc. Fried Chicken w/ Rice and Drink"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_chicwdrink);
        }
        else if (ff.getFf_name().equals("Regular-sized Fries"))
        {
            holder.img.setImageResource(R.drawable.kfc_logo);
        }
        else if (ff.getFf_name().equals("Medium-sized Fries"))
        {
            holder.img.setImageResource(R.drawable.wendys_logo);
        }
        else if (ff.getFf_name().equals("Large-sized Fries"))
        {
            holder.img.setImageResource(R.drawable.popeyes_logo);
        }
        else if (ff.getFf_name().equals("Vanilla Sundae"))
        {
            holder.img.setImageResource(R.drawable.popeyes_logo);
        }

        holder.ffObj.setTag(ff);
        holder.ffObj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity.ffObj((FoodList_ff) v.getTag());
            }
        });
    }
}
