package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_order_success)
public class OrderSuccess extends AppCompatActivity {
//    Get Views
    @ViewById
    Button order_success_logout;

    @ViewById
    Button order_success_reorder;


//    Function for reorder
    @Click
    public void order_success_reorder()
    {
        OrderPage_.intent(this).start();
    }
    @Click
    public void order_success_logout()
    {
        LoginPage_.intent(this).start();
        finish();
    }
}