package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.foodpapa2021.adapters.FastCasualMenu;
import com.example.foodpapa2021.realm.FoodList_fc;
import com.example.foodpapa2021.realm.RestaurantList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_restaurant_page)
public class RestaurantPage extends AppCompatActivity {
    SharedPreferences prefs;
    Realm realm;

    @ViewById
    RecyclerView res_page_foodlist;

    @AfterViews
    public void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        res_page_foodlist.setLayoutManager(mLayoutManager);

        RealmResults<FoodList_fc> list = realm.where(FoodList_fc.class).findAll();
        FastCasualMenu fcAdapter = new FastCasualMenu(this, list, true);
        res_page_foodlist.setAdapter(fcAdapter);
    }

    public void fcObj(FoodList_fc fc)
    {
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("fc_uuid", fc.getUuid());
        edit.apply();

        FoodDetail_.intent(this).start();
    }
}