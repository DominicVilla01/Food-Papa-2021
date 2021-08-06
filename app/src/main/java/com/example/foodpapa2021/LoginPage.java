package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodpapa2021.realm.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

@EActivity(R.layout.activity_login_page)
public class LoginPage extends AppCompatActivity {

    //Variables
    SharedPreferences prefs;
    Realm realm;

    //Login
    @ViewById
    EditText user_input;

    @ViewById
    EditText pass_input;

    //To sign up page
    @ViewById
    TextView register;

    @ViewById
    Button signin_apply;

    @ViewById
    CheckBox remember;

    //Other login options
    @ViewById
    ImageView facebook;

    @ViewById
    ImageView google;

    @ViewById
    ImageView twitter;

    @AfterViews
    public void init()
    {
        //Underline Register here!
        register.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        //Initialize Realm
        realm = Realm.getDefaultInstance();

        //Initialize SharedPreferences
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        //Store checkbox status in a variable
        boolean cboxValue = prefs.getBoolean("remember",false);

        //Store the remembered uuid in a variable, return null if none
        String uuid = prefs.getString("uuid", null);

        //Find the object using the uuid...[this returns a null if none]
        User result = realm.where(User.class)
                           .equalTo("uuid", uuid)
                           .findFirst();

        //Check if user checked Remember me
        if(cboxValue && result != null) //cboxValue is true and result returns an object
        {
            user_input.setText(result.getName());
            pass_input.setText(result.getPass());
            remember.setChecked(true);
        }
        else
        {
            user_input.setText("");
            pass_input.setText("");
        }
    }
    @Click
    public void signin_apply()
    {
        String username = user_input.getText().toString();
        String password = pass_input.getText().toString();

        //Find the object if it's in the database
        User result = realm.where(User.class)
                           .equalTo("name", username)
                           .findFirst();

        if(result!=null) //If it's in the database
        {
            //Store the data name and pass in a variable
            String userObj = result.getName();
            String passObj = result.getPass();

            //Check if the user inputs are correct
            if(username.equals(userObj) && password.equals(passObj))
            {
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("uuid", result.getUuid());

                //Remember me
                boolean cboxValue = remember.isChecked();
                edit.putBoolean("remember", cboxValue);
                edit.apply();

                //Order Page
                OrderPage_.intent(this).start();
            }
            else
            {
                Toast.makeText(this,"Incorrect credentials", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"No User found", Toast.LENGTH_SHORT).show();
        }
    }
    @Click
    public void register()
    {
        SignUp_.intent(this).start();
    }
}