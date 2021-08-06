package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_category_page)
public class CategoryPage extends AppCompatActivity {
//    Set Variables
    SharedPreferences prefs;

//    Get Views
    @ViewById
    ImageView cat_page_img;

    @ViewById
    TextView textView49;


//    Manage data
    @AfterViews
    public void init()
    {
//        Retrieve user choice
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String choice = prefs.getString("OrderClick", null);

//        Process user choice
        processClick(choice);
    }


//    Function for processing category choice
    public void processClick(String click_option)
    {
        if(click_option.equals("fastfood"))
        {
            textView49.setText("Category: Fast Food");
            cat_page_img.setImageResource(R.drawable.fast_food);
        }
        else if(click_option.equals("milktea"))
        {
            textView49.setText("Category: Milk Tea");
            cat_page_img.setImageResource(R.drawable.milktea);
        }
        else if(click_option.equals("fastcasual"))
        {
            textView49.setText("Category: Fast-Casual");
            cat_page_img.setImageResource(R.drawable.fast_casual);
        }
    }
}