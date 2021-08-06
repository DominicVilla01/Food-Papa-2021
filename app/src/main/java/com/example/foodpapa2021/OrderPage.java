package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_order_page)
public class OrderPage extends AppCompatActivity {

    @ViewById
    AutoCompleteTextView order_page_location;

    @AfterViews
    public void init(){
        String[] locations = getResources().getStringArray(R.array.locations);
        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,locations);
        order_page_location.setAdapter(adapter);

    }
}