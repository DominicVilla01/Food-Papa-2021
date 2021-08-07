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
        FoodList_ff cat = getItem(position);

        holder.name.setText(ff.getFf_name());
        holder.price.setText(ff.getFf_price());

        if (ff.getFf_name().equals("Jollibee"))
        {
            holder.img.setImageResource(R.drawable.jollibee_logo);
        }
        else if (ff.getFf_name().equals("McDo"))
        {
            holder.img.setImageResource(R.drawable.mcdo_logo);
        }
        else if (ff.getFf_name().equals("KFC"))
        {
            holder.img.setImageResource(R.drawable.kfc_logo);
        }
        else if (ff.getFf_name().equals("Wendy's"))
        {
            holder.img.setImageResource(R.drawable.wendys_logo);
        }
        else if (ff.getFf_name().equals("Popeyes"))
        {
            holder.img.setImageResource(R.drawable.popeyes_logo);
        }

        holder.ffobj.setTag(ff);
        holder.ffobj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity.ffObj((FoodList_ff) v.getTag());
            }
        });
    }
}
