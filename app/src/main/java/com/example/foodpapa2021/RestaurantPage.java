package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodpapa2021.realm.RestaurantList;
import com.example.foodpapa2021.realm.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

@EActivity(R.layout.activity_restaurant_page)
public class RestaurantPage extends AppCompatActivity {
    //variables
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
    }
}