package com.example.foodpapa2021.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodpapa2021.OrderPage;
import com.example.foodpapa2021.OrderPage_;
import com.example.foodpapa2021.R;
import com.example.foodpapa2021.RestaurantPage_;
import com.example.foodpapa2021.realm.RestaurantList;

import javax.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class RestaurantAdapter extends RealmRecyclerViewAdapter<RestaurantList, RestaurantAdapter.ViewHolder> {
    OrderPage activity;

    public RestaurantAdapter(OrderPage activity, @Nullable OrderedRealmCollection<RestaurantList> data, boolean autoUpdate){
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView rating;
        TextView del_time;
        TextView res_cat;
        ConstraintLayout resObj;

        public ViewHolder(@NonNull View restaurantView){
            super(restaurantView);

            img = restaurantView.findViewById(R.id.res_img);
            name = restaurantView.findViewById(R.id.res_title);
            rating = restaurantView.findViewById(R.id.ratings);
            del_time = restaurantView.findViewById(R.id.delivery_time);
            res_cat = restaurantView.findViewById(R.id.res_cat);
            resObj = restaurantView.findViewById(R.id.resturant_obj);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.restaurant_objects, parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        RestaurantList res = getItem(position);

        holder.name.setText(res.getRes_name());
        holder.rating.setText(res.getRes_rating());
        holder.res_cat.setText(res.getRes_cat());
        holder.del_time.setText(res.getRes_time_distance());

        //Fast Food
        if(res.getRes_name().equals("Jollibee"))
        {
            holder.img.setImageResource(R.drawable.jollibee_logo);
        }
        else if(res.getRes_name().equals("McDo"))
        {
            holder.img.setImageResource(R.drawable.mcdo_logo);
        }
        else if(res.getRes_name().equals("KFC"))
        {
            holder.img.setImageResource(R.drawable.kfc_logo);
        }
        else if(res.getRes_name().equals("Wendy's"))
        {
            holder.img.setImageResource(R.drawable.wendys_logo);
        }
        else if(res.getRes_name().equals("Popeyes"))
        {
            holder.img.setImageResource(R.drawable.popeyes_logo);
        }
        //Milk Tea
        else if(res.getRes_name().equals("CoCo Fresh Tea & Juice"))
        {
            holder.img.setImageResource(R.drawable.coco_logo);
        }
        else if(res.getRes_name().equals("Gongcha"))
        {
            holder.img.setImageResource(R.drawable.gongcha_logo);
        }
        else if(res.getRes_name().equals("Serenitea"))
        {
            holder.img.setImageResource(R.drawable.serenitea_logo);
        }
        else if(res.getRes_name().equals("Macao Imperial Tea"))
        {
            holder.img.setImageResource(R.drawable.macao_logo);
        }
        else if(res.getRes_name().equals("Tiger Sugar"))
        {
            holder.img.setImageResource(R.drawable.tiger_logo);
        }

        //Fast-Casual Category
        else if(res.getRes_name().equals("TGI Fridays"))
        {
            holder.img.setImageResource(R.drawable.tgif_logo);
        }
        else if(res.getRes_name().equals("Outback Steakhouse"))
        {
            holder.img.setImageResource(R.drawable.outback_logo);
        }
        else if(res.getRes_name().equals("Claw Daddy"))
        {
            holder.img.setImageResource(R.drawable.clawdaddy_logo);
        }
        else if(res.getRes_name().equals("Italianni's"))
        {
            holder.img.setImageResource(R.drawable.italiannis_logo);
        }
        else if(res.getRes_name().equals("Racks"))
        {
            holder.img.setImageResource(R.drawable.racks_logo);
        }
        holder.resObj.setTag(res);
        holder.resObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.resObj((RestaurantList) v.getTag());
            }
        });
    }
}
