package com.example.foodpapa2021.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodpapa2021.Cart;
import com.example.foodpapa2021.R;
import com.example.foodpapa2021.realm.OrderList;

import javax.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class OrderAdapter extends RealmRecyclerViewAdapter<OrderList, OrderAdapter.ViewHolder> {
    Cart activity;

    public OrderAdapter(Cart activity, @Nullable OrderedRealmCollection<OrderList> data, boolean autoUpdate){
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView price;
        TextView name;
        TextView quantity;
        ImageView img;
        ImageView minus;
        ImageView add;


        public ViewHolder(@NonNull View orderView){
            super(orderView);

            price = orderView.findViewById(R.id.cart_food_price);
            name = orderView.findViewById(R.id.cart_food_name);
            img = orderView.findViewById(R.id.cart_img);
            minus = orderView.findViewById(R.id.order_detail_subtract);
            add = orderView.findViewById(R.id.order_detail_add);
            quantity = orderView.findViewById(R.id.order_quantity);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.edit_orders, parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        OrderList order = getItem(position);

        holder.name.setText(order.getOrder_name());
        holder.price.setText(String.valueOf(order.getOrder_price()));
        holder.quantity.setText(String.valueOf(order.getOrder_quantity()));


        if (order.getOrder_name().equals("1-pc. Fried Chicken"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_chicken);
        }
        else if (order.getOrder_name().equals("1-pc. Fried Chicken w/ Rice and Drink"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_chicwdrink);
        }
        else if (order.getOrder_name().equals("Regular-sized Fries"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        }
        else if (order.getOrder_name().equals("Medium-sized Fries"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        }
        else if (order.getOrder_name().equals("Large-sized Fries"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        }
        else if (order.getOrder_name().equals("Vanilla Sundae"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_jollibee_sundae);
        }

        else if (order.getOrder_name().equals("Classic with Pearls"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_pearl);
        }
        else if (order.getOrder_name().equals("Classic"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_classic);
        }
        else if (order.getOrder_name().equals("Brown Sugar Milk Tea"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_sugar);
        }
        else if (order.getOrder_name().equals("Black Iced Tea"))
        {
            holder.img.setImageResource(R.drawable.foodlist_img_coco_black);
        }

        else if (order.getOrder_name().equals("Baby Back Ribs")) {
            holder.img.setImageResource(R.drawable.foodlist_img_outback_ribs);
        } else if (order.getOrder_name().equals("Caesar Salad")) {
            holder.img.setImageResource(R.drawable.foodlist_img_outback_salad);
        } else if (order.getOrder_name().equals("Iced Tea")) {
            holder.img.setImageResource(R.drawable.foodlist_img_icedtea);
        } else if (order.getOrder_name().equals("Spaghetti")) {
            holder.img.setImageResource(R.drawable.foodlist_img_outback_pasta);
        }

        holder.minus.setTag(order);
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.minus((OrderList) v.getTag());
            }
        });

        holder.add.setTag(order);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.add((OrderList) v.getTag());
            }
        });
    }
}
