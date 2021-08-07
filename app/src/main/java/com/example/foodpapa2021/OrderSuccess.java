package com.example.foodpapa2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodpapa2021.realm.OrderList;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

@EActivity(R.layout.activity_order_success)
public class OrderSuccess extends AppCompatActivity {
//    Set Vars
    Realm realm;

//    Get Views
    @ViewById
    Button order_success_logout;

    @ViewById
    Button order_success_reorder;


//    Function for reorder
    public void order_success_reorder()
    {
        OrderPage_.intent(this).start();
    }


//    Function for logout
    @Click
    public void order_success_logout()
    {
        
    }
    public void delete(OrderList u)
    {
        if(u.isValid())
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Confirmation");
            alert.setMessage("Are you sure you want to log out?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    realm.beginTransaction();
                    u.deleteFromRealm();
                    realm.commitTransaction();
                    Toast.makeText(OrderSuccess.this, "You have Logged out", Toast.LENGTH_SHORT).show();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(OrderSuccess.this, "Log out cancelled", Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();
        }
    }
}