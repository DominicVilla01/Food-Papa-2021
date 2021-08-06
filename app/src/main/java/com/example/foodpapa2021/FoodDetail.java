package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_food_detail)
public class FoodDetail extends AppCompatActivity {
    //variables
    int quantity = 1;

    @ViewById
    ImageView food_detail_add;

    @ViewById
    ImageView food_detail_subtract;

    @ViewById
    ImageView food_detail_foodimg;

    @ViewById
    TextView food_detail_quantity;

    @ViewById
    Button food_detail_updateBasket;

    @AfterViews
    public void init(){
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_add(){
        quantity++;
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_subtract(){
        quantity--;
        if(quantity>0)
        {
            food_detail_quantity.setText(String.valueOf(quantity));
        }
        else if(quantity < 0){
            quantity = 0;
            food_detail_quantity.setText(String.valueOf(quantity));
        }
    }

    @Click
    public void food_detail_updateBasket(){
        food_detail_foodimg.setImageResource(R.drawable.foodpapa_logo1);
        food_detail_foodimg.setImageResource(R.drawable.foodpapa_logo2);
    }

}