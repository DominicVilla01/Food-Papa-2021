package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodpapa2021.realm.FoodList_fc;
import com.example.foodpapa2021.realm.OrderList;
import com.example.foodpapa2021.realm.RestaurantList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;

@EActivity(R.layout.activity_food_detail)
public class FoodDetail extends AppCompatActivity {
    //variables
    int quantity = 1;
    SharedPreferences prefs;
    Realm realm;

    @ViewById
    ImageView food_detail_add;

    @ViewById
    ImageView food_detail_subtract;

    @ViewById
    ImageView food_detail_foodimg;

    @ViewById
    TextView food_detail_price;

    @ViewById
    TextView food_detail_foodname;

    @ViewById
    TextView food_detail_quantity;

    @ViewById
    Button food_detail_updateBasket;

    @AfterViews
    public void init() {
        food_detail_quantity.setText(String.valueOf(quantity));
        prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        String name = prefs.getString("food_name", null);
        String price = prefs.getString("food_price", null);

        food_detail_foodname.setText(name);
        food_detail_price.setText(price);

        if (name.equals("1-pc. Fried Chicken"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_chicken);
        }
        else if (name.equals("1-pc. Fried Chicken w/ Rice and Drink"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_chicwdrink);
        }
        else if (name.equals("Regular-sized Fries"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        }
        else if (name.equals("Medium-sized Fries"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        }
        else if (name.equals("Large-sized Fries"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        }
        else if (name.equals("Vanilla Sundae"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_sundae);
        }

        else if (name.equals("Classic with Pearls"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_pearl);
        }
        else if (name.equals("Classic"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_classic);
        }
        else if (name.equals("Brown Sugar Milk Tea"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_sugar);
        }
        else if (name.equals("Black Iced Tea"))
        {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_black);
        }

        else if (name.equals("Baby Back Ribs")) {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_ribs);
        } else if (name.equals("Caesar Salad")) {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_salad);
        } else if (name.equals("Iced Tea")) {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_icedtea);
        } else if (name.equals("Spaghetti")) {
            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_pasta);
        }

    }

    @Click
    public void food_detail_add() {
        quantity++;
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_subtract() {
        quantity--;
        if (quantity > 0) {
            food_detail_quantity.setText(String.valueOf(quantity));
        } else if (quantity < 0) {
            quantity = 0;
            food_detail_quantity.setText(String.valueOf(quantity));
        }
    }

    @Click
    public void food_detail_updateBasket() {

        realm = Realm.getDefaultInstance();
        OrderList newOrder = new OrderList();
        newOrder.setUuid(UUID.randomUUID().toString());
        newOrder.setOrder_name(food_detail_foodname.getText().toString());
        newOrder.setOrder_price(food_detail_price.getText().length());
        newOrder.setOrder_quantity(food_detail_quantity.getText().length());

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(newOrder);
        realm.commitTransaction();

        Toast.makeText(this,"Added a new order",Toast.LENGTH_SHORT).show();
        finish();
    }
}