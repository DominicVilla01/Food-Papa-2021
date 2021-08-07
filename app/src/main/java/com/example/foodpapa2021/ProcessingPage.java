package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

@EActivity(R.layout.activity_processing_page)
public class ProcessingPage extends AppCompatActivity
{
    //variables
    SharedPreferences prefs;
    Realm realm;

    @ViewById
    TextView processing_time;

    @ViewById
    TextView processing_payment_method;

    @ViewById
    TextView processing_total_bill;

    @ViewById
    Button processing_page_received;

    @AfterViews
    public void init(){
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean pmethod = prefs.getBoolean("paymentMethod", false);
        if(pmethod){
            processing_payment_method.setText("Card");
        }
        else
        {
            processing_payment_method.setText("Cash");
        }

    }
    
    @Click
    public void processing_page_received(){

    }
    public void onDestroy()
    {
        super.onDestroy();
        if(!realm.isClosed())
        {
            realm.close();
        }
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(this, "Sorry but your order has already been processed", Toast.LENGTH_SHORT).show();
    }
}