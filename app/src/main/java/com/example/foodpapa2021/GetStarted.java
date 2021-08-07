package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.foodpapa2021.realm.RestaurantList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;

@EActivity(R.layout.activity_get_started)
public class GetStarted extends AppCompatActivity {
    Realm realm;
    SharedPreferences prefs;
    int tracker = 0;

    @ViewById
    Button getStarted;

    @AfterViews
    public void init(){
        prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        String status = prefs.getString("status", null);
        if(status != null){
            LoginPage_.intent(this).start();
        }
    }
    @Click
    public void getStarted()
    {
        realm = Realm.getDefaultInstance();

        //This will stop realm from creating more than one of the same obj
        if(tracker == 0){
            tracker++;
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString("status", "data_passed");
            edit.apply();

            RestaurantList jollibee = new RestaurantList();
            jollibee.setUuid(UUID.randomUUID().toString());
            jollibee.setRes_name("Jollibee");
            jollibee.setRes_rating("4.6");
            jollibee.setRes_time_distance("34mins • 1.4km");
            jollibee.setRes_cat("Fast Food");

            RestaurantList mcdo = new RestaurantList();
            mcdo.setUuid(UUID.randomUUID().toString());
            mcdo.setRes_name("McDo");
            mcdo.setRes_rating("4.7");
            mcdo.setRes_time_distance("35mins • 1.5km");
            mcdo.setRes_cat("Fast Food");

            RestaurantList kfc = new RestaurantList();
            kfc.setUuid(UUID.randomUUID().toString());
            kfc.setRes_name("KFC");
            kfc.setRes_rating("4.5");
            kfc.setRes_time_distance("33mins • 1.3km");
            kfc.setRes_cat("Fast Food");

            RestaurantList wendy = new RestaurantList();
            wendy.setUuid(UUID.randomUUID().toString());
            wendy.setRes_name("Wendy's");
            wendy.setRes_rating("4.5");
            wendy.setRes_time_distance("35mins • 1.4km");
            wendy.setRes_cat("Fast Food");

            RestaurantList popeyes = new RestaurantList();
            popeyes.setUuid(UUID.randomUUID().toString());
            popeyes.setRes_name("Popeyes");
            popeyes.setRes_rating("4.5");
            popeyes.setRes_time_distance("36mins • 1.5km");
            popeyes.setRes_cat("Fast Food");

            RestaurantList coco = new RestaurantList();
            coco.setUuid(UUID.randomUUID().toString());
            coco.setRes_name("CoCo Fresh Tea & Juice");
            coco.setRes_rating("4.6");
            coco.setRes_time_distance("33mins • 1.2km");
            coco.setRes_cat("Milk Tea");

            RestaurantList gongcha = new RestaurantList();
            gongcha.setUuid(UUID.randomUUID().toString());
            gongcha.setRes_name("Gongcha");
            gongcha.setRes_rating("4.6");
            gongcha.setRes_time_distance("33mins • 1.2km");
            gongcha.setRes_cat("Milk Tea");

            RestaurantList seren = new RestaurantList();
            seren.setUuid(UUID.randomUUID().toString());
            seren.setRes_name("Serenitea");
            seren.setRes_rating("4.5");
            seren.setRes_time_distance("36mins • 1.5km");
            seren.setRes_cat("Milk Tea");

            RestaurantList macao = new RestaurantList();
            macao.setUuid(UUID.randomUUID().toString());
            macao.setRes_name("Macao Imperial Tea");
            macao.setRes_rating("4.7");
            macao.setRes_time_distance("36mins • 1.5km");
            macao.setRes_cat("Milk Tea");

            RestaurantList tiger = new RestaurantList();
            tiger.setUuid(UUID.randomUUID().toString());
            tiger.setRes_name("Tiger Sugar");
            tiger.setRes_rating("4.7");
            tiger.setRes_time_distance("36mins • 1.5km");
            tiger.setRes_cat("Milk Tea");

            RestaurantList tgif = new RestaurantList();
            tgif.setUuid(UUID.randomUUID().toString());
            tgif.setRes_name("TGI Fridays");
            tgif.setRes_rating("4.8");
            tgif.setRes_time_distance("34mins • 1.2km");
            tgif.setRes_cat("Fast-Casual");

            RestaurantList outback = new RestaurantList();
            outback.setUuid(UUID.randomUUID().toString());
            outback.setRes_name("Outback Steakhouse");
            outback.setRes_rating("4.7");
            outback.setRes_time_distance("32mins • 1.1km");
            outback.setRes_cat("Fast-Casual");

            RestaurantList claw = new RestaurantList();
            claw.setUuid(UUID.randomUUID().toString());
            claw.setRes_name("Claw Daddy");
            claw.setRes_rating("4.6");
            claw.setRes_time_distance("33mins • 1.2km");
            claw.setRes_cat("Fast-Casual");

            RestaurantList ital = new RestaurantList();
            ital.setUuid(UUID.randomUUID().toString());
            ital.setRes_name("Italianni's");
            ital.setRes_rating("4.5");
            ital.setRes_time_distance("36mins • 1.5km");
            ital.setRes_cat("Fast-Casual");

            RestaurantList racks = new RestaurantList();
            racks.setUuid(UUID.randomUUID().toString());
            racks.setRes_name("Racks");
            racks.setRes_rating("4.7");
            racks.setRes_time_distance("36mins • 1.5km");
            racks.setRes_cat("Fast-Casual");



            realm.beginTransaction();
            realm.copyToRealmOrUpdate(jollibee);
            realm.copyToRealmOrUpdate(mcdo);
            realm.copyToRealmOrUpdate(kfc);
            realm.copyToRealmOrUpdate(wendy);
            realm.copyToRealmOrUpdate(popeyes);
            realm.copyToRealmOrUpdate(coco);
            realm.copyToRealmOrUpdate(gongcha);
            realm.copyToRealmOrUpdate(seren);
            realm.copyToRealmOrUpdate(macao);
            realm.copyToRealmOrUpdate(tiger);
            realm.copyToRealmOrUpdate(tgif);
            realm.copyToRealmOrUpdate(outback);
            realm.copyToRealmOrUpdate(claw);
            realm.copyToRealmOrUpdate(ital);
            realm.copyToRealmOrUpdate(racks);

            realm.commitTransaction();

            LoginPage_.intent(this).start();
        }
        else{
            LoginPage_.intent(this).start();
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
}