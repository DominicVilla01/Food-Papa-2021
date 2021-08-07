package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;

import com.example.foodpapa2021.adapters.RestaurantAdapter;
import com.example.foodpapa2021.realm.RestaurantList;
import com.example.foodpapa2021.realm.User;
import com.example.foodpapa2021.user_settings.EditUser_;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.androidannotations.annotations.Click;
import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_order_page)
public class OrderPage extends AppCompatActivity {
//    Set vars
    SharedPreferences prefs;
    Realm realm;

//    Set Views
    @ViewById
    AutoCompleteTextView order_page_location;

    @ViewById
    FloatingActionButton order_page_cart;

    @ViewById
    RecyclerView res_list;

    @ViewById
    ImageView account_settings;

    @ViewById
    ImageView home_settings;

    @ViewById
    ImageView cat_fastfood;

    @ViewById
    ImageView cat_milktea;

    @ViewById
    ImageView cat_fast_casual;

    @ViewById
    TextView order_page_welcome;

//    Initialize data
    @AfterViews
    public void init() {
        //Call realm
        realm = Realm.getDefaultInstance();

        //Call SharedPreferences
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);

        String[] locations = getResources().getStringArray(R.array.locations);
        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,locations);
        order_page_location.setAdapter(adapter);

        //Welcome Message
        String user = prefs.getString("uuid", null);
        User name = realm.where(User.class)
                .equalTo("uuid", user)
                .findFirst();

        order_page_welcome.setText("Welcome " + name.getName() + "!");

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        res_list.setLayoutManager(mLayoutManager);

        RealmResults<RestaurantList> list = realm.where(RestaurantList.class).findAll();
        RestaurantAdapter resAdapter = new RestaurantAdapter(this,list,true);
        res_list.setAdapter(resAdapter);

    }
    @Click
    public void order_page_cart() {
        String loc = order_page_location.getText().toString();

        if (!loc.equals("")) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString("location", order_page_location.getText().toString());
            edit.apply();
            Cart_.intent(this).start();
        } else {
            Toast.makeText(this, "Please enter a location", Toast.LENGTH_SHORT).show();
        }
    }

    @Click
    public void cat_fastfood() {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("OrderClick", "Fast Food");
        edit.apply();

        CategoryPage_.intent(this).start();
    }

    @Click
    public void cat_milktea() {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("OrderClick", "Milk Tea");
        edit.apply();

        CategoryPage_.intent(this).start();
    }

    @Click
    public void cat_fast_casual() {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("OrderClick", "Fast-Casual");
        edit.apply();

        CategoryPage_.intent(this).start();
    }

    @Click
    public void account_settings(){
        EditUser_.intent(this).start();
        finish();
    }

    @Click
    public void home_settings(){
        OrderPage_.intent(this).start();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if(!realm.isClosed())
        {
            realm.close();
        }
    }
    public void resObj(RestaurantList res)
    {
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("res_name", res.getRes_name());
        edit.putString("cat_data", res.getRes_cat());
        edit.apply();

        RestaurantPage_.intent(this).start();
    }
}