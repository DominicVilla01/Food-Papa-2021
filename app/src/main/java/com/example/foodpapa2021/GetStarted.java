package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

<<<<<<< Updated upstream
=======
import com.example.foodpapa2021.realm.CategoryList;
import com.example.foodpapa2021.realm.FoodList_ff;
import com.example.foodpapa2021.realm.RestaurantList;

>>>>>>> Stashed changes
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_get_started)
public class GetStarted extends AppCompatActivity {

    @ViewById
    Button getStarted;

    @Click
    public void getStarted()
    {
        OrderPage_.intent(this).start();
    }

    @AfterViews
    public void init()
    {

    }
}