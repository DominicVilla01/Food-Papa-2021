package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_order_page)
public class OrderPage<adapter> extends AppCompatActivity
{
//    private static final String[] locations = new String[]{"Paranaque, Makati, Quezon City"};

    String[] locations = getResources().getStringArray(R.array.locations);

    @ViewById
    AutoCompleteTextView order_page_location;
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, locations);

    @AfterViews
    public AutoCompleteTextView getOrder_page_location() {
        order_page_location.setAdapter(adapter);
        return order_page_location;
    }
}