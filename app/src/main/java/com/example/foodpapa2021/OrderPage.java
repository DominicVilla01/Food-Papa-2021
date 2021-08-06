package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.foodpapa2021.user_settings.EditUser_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_order_page)
public class OrderPage extends AppCompatActivity {

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


}