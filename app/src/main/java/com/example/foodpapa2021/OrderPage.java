package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import com.example.foodpapa2021.user_settings.EditUser_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_order_page)
public class OrderPage extends AppCompatActivity {
//    Set vars
    SharedPreferences prefs;

<<<<<<< HEAD

//    Set Views
    @ViewById
    ConstraintLayout cat_fastfood;

    @ViewById
    ConstraintLayout cat_milktea;

    @ViewById
    ConstraintLayout cat_fast_casual;

    @Click
    public void cat_fastfood()
    {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("OrderClick", "fastfood");
        edit.apply();

        CategoryPage_.intent(this).start();
    }

    @Click
    public void cat_milktea()
    {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("OrderClick", "milktea");
        edit.apply();

        CategoryPage_.intent(this).start();
    }

    @Click
    public void cat_fast_casual()
    {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("OrderClick", "fastcasual");
        edit.apply();

        CategoryPage_.intent(this).start();
    }


//    Initialize Shared Preferences
    @AfterViews
    public void init()
    {
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
    }
=======
    @ViewById
    ImageView account_settings;

    @ViewById
    ImageView home_settings;

    @Click
    public void account_settings(){
        EditUser_.intent(this).start();
    }

    @Click
    public void home_settings(){
        OrderPage_.intent(this).start();
    }


>>>>>>> 85b9f2379330b6eefd337e391d965e6e14287581
}