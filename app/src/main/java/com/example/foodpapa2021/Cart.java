package com.example.foodpapa2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodpapa2021.adapters.FastCasualMenu;
import com.example.foodpapa2021.adapters.OrderAdapter;
import com.example.foodpapa2021.realm.FoodList_fc;
import com.example.foodpapa2021.realm.FoodList_ff;
import com.example.foodpapa2021.realm.OrderList;
import com.example.foodpapa2021.realm.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmObjectChangeListener;
import io.realm.RealmResults;

@EActivity(R.layout.activity_cart)
public class Cart extends AppCompatActivity {
    //Variables
    SharedPreferences prefs;
    Realm realm;

    @ViewById
    TextView cart_page_location;

    @ViewById
    TextView cart_page_item_total;

    @ViewById
    TextView cart_page_dFee;

    @ViewById
    TextView cart_page_totalBill;

    @ViewById
    Switch cart_page_pMethod;

    @ViewById
    Button cart_page_checkout;

    @ViewById
    RecyclerView cart_order_list;


    @AfterViews
    public void init()
    {
        realm = Realm.getDefaultInstance();
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        //Set location
        String location = prefs.getString("location", null);
        int total = prefs.getInt("total", 0);
        cart_page_item_total.setText("Php " + total);
        cart_page_location.setText(location);

        //Delivery fee
        if(location.equals("Outside NCR")){
            cart_page_dFee.setText("Php 76");
            cart_page_totalBill.setText("Php" + (total + 76));

            SharedPreferences.Editor edit = prefs.edit();
            edit.putInt("finalbill", total+76);
            edit.apply();

        }
        else if(location.equals("Within NCR")){
            cart_page_dFee.setText("Php 59");
            cart_page_totalBill.setText("Php" + (total + 59));
            SharedPreferences.Editor edit = prefs.edit();
            edit.putInt("finalbill", total+59);
            edit.apply();
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        cart_order_list.setLayoutManager(mLayoutManager);

        RealmResults<OrderList> list = realm.where(OrderList.class).findAll();
        OrderAdapter foodAdapter = new OrderAdapter(this,list,true);
        cart_order_list.setAdapter(foodAdapter);
    }

    @Click
    public void cart_page_checkout(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Process Order");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Payment Method
                if(cart_page_pMethod.isChecked()){
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putBoolean("paymentMethod", true);
                    edit.apply();
                }
                else
                {
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putBoolean("paymentMethod", false);
                    edit.apply();
                }

                Toast.makeText(Cart.this, "Processed Order", Toast.LENGTH_SHORT).show();
                ProcessingPage_.intent(Cart.this).start();
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Cart.this, "Back to cart", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }

    public void minus(OrderList order)
    {
        int changes = prefs.getInt("total", 0);
        int current = order.getOrder_quantity();
        int price = order.getOrder_price();

        realm.beginTransaction();
        if(current>1) {
            order.setOrder_quantity(current - 1);
            changes = changes - price;
            SharedPreferences.Editor edit = prefs.edit();
            edit.putInt("total", changes);
            edit.apply();
            Intent refresh = new Intent(this, Cart_.class);
            startActivity(refresh);
            finish();
        }
        else{
            changes = changes - price;
            SharedPreferences.Editor edit = prefs.edit();
            edit.putInt("total", changes);
            edit.apply();

            realm = Realm.getDefaultInstance();
            OrderList order_quantity = realm.where(OrderList.class).equalTo("order_quantity", current).findFirst();
            order_quantity.deleteFromRealm();

            Intent refresh = new Intent(this, Cart_.class);
            startActivity(refresh);
            finish();
        }
        realm.commitTransaction();

    }
    public void add(OrderList order)
    {
        int current = order.getOrder_quantity();
        int price = order.getOrder_price();

        realm.beginTransaction();
        order.setOrder_quantity(current+1);
        realm.commitTransaction();

        int changes = prefs.getInt("total", 0);
        changes = changes + price;

        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt("total", changes);
        edit.apply();

        Intent refresh = new Intent(this, Cart_.class);
        startActivity(refresh);
        finish();
    }


}