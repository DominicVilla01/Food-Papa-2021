package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodpapa2021.adapters.CategoryAdapter;
import com.example.foodpapa2021.adapters.FastFoodMenu;
import com.example.foodpapa2021.adapters.MilkteaMenu;
import com.example.foodpapa2021.realm.CategoryList;
import com.example.foodpapa2021.realm.FoodList_ff;
import com.example.foodpapa2021.realm.FoodList_m;
import com.example.foodpapa2021.realm.RestaurantList;
import com.example.foodpapa2021.realm.User;
import com.example.foodpapa2021.adapters.FastCasualMenu;
import com.example.foodpapa2021.realm.FoodList_fc;

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
    ImageView res_page_img;

    @ViewById
    TextView res_page_name;

    @ViewById
    TextView res_page_rating;

    @ViewById
    TextView res_page_dTime;

    @ViewById
    RecyclerView res_page_foodlist;

    @AfterViews
    public void init(){

        realm = Realm.getDefaultInstance();

        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        String res_name = prefs.getString("res_name", null);
        String cat_data = prefs.getString("cat_data", null);

        RestaurantList result = realm.where(RestaurantList.class)
                .equalTo("res_name", res_name)
                .findFirst();

        if(res_name.equals("Jollibee"))
        {
            res_page_img.setImageResource(R.drawable.jollibee_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());

        }
        else if(res_name.equals("McDo"))
        {
            res_page_img.setImageResource(R.drawable.mcdo_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("KFC"))
        {
            res_page_img.setImageResource(R.drawable.kfc_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Wendy's"))
        {
            res_page_img.setImageResource(R.drawable.wendys_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Popeyes"))
        {
            res_page_img.setImageResource(R.drawable.popeyes_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        //Milk Tea
        else if(res_name.equals("CoCo Fresh Tea & Juice"))
        {
            res_page_img.setImageResource(R.drawable.coco_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Gongcha"))
        {
            res_page_img.setImageResource(R.drawable.gongcha_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Serenitea"))
        {
            res_page_img.setImageResource(R.drawable.serenitea_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Macao Imperial Tea"))
        {
            res_page_img.setImageResource(R.drawable.macao_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Tiger Sugar"))
        {
            res_page_img.setImageResource(R.drawable.tiger_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }

        //Fast-Casual Category
        else if(res_name.equals("TGI Fridays"))
        {
            res_page_img.setImageResource(R.drawable.tgif_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Outback Steakhouse"))
        {
            res_page_img.setImageResource(R.drawable.outback_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Claw Daddy"))
        {
            res_page_img.setImageResource(R.drawable.clawdaddy_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Italianni's"))
        {
            res_page_img.setImageResource(R.drawable.italiannis_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }
        else if(res_name.equals("Racks"))
        {
            res_page_img.setImageResource(R.drawable.racks_logo);
            res_page_name.setText(result.getRes_name());
            res_page_rating.setText(result.getRes_rating());
            res_page_dTime.setText(result.getRes_time_distance());
        }

        if(result.getRes_cat().equals("Fast Food"))
        {
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setOrientation(RecyclerView.VERTICAL);
            res_page_foodlist.setLayoutManager(mLayoutManager);

            RealmResults<FoodList_ff> list = realm.where(FoodList_ff.class).findAll();
            FastFoodMenu foodAdapter = new FastFoodMenu(this,list,true);
            res_page_foodlist.setAdapter(foodAdapter);
        }
        else if(result.getRes_cat().equals("Milk Tea")){
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setOrientation(RecyclerView.VERTICAL);
            res_page_foodlist.setLayoutManager(mLayoutManager);

            RealmResults<FoodList_m> list = realm.where(FoodList_m.class).findAll();
            MilkteaMenu foodAdapter = new MilkteaMenu(this,list,true);
            res_page_foodlist.setAdapter(foodAdapter);
        }
        else if(result.getRes_cat().equals("Fast-Casual")){
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setOrientation(RecyclerView.VERTICAL);
            res_page_foodlist.setLayoutManager(mLayoutManager);

            RealmResults<FoodList_fc> list = realm.where(FoodList_fc.class).findAll();
            FastCasualMenu foodAdapter = new FastCasualMenu(this,list,true);
            res_page_foodlist.setAdapter(foodAdapter);
        }
    }
    public void onDestroy()
    {
        super.onDestroy();
        if(!realm.isClosed())
        {
            realm.close();
        }
    }
    public void ffObj(FoodList_ff ff)
    {
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("food_name", ff.getFf_name());
        edit.putInt("food_price", ff.getFf_price());
        edit.apply();

        FoodDetail_.intent(this).start();
    }
    public void mObj(FoodList_m m)
    {
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("food_name", m.getM_name());
        edit.putInt("food_price", m.getM_price());
        edit.apply();

        FoodDetail_.intent(this).start();
    }
    public void fcObj(FoodList_fc fc)
    {
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("food_name", fc.getFc_name());
        edit.putInt("food_price", fc.getFc_price());
        edit.apply();

        FoodDetail_.intent(this).start();
    }

}