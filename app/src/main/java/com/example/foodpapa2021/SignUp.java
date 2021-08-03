package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodpapa2021.realm.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;

@EActivity(R.layout.activity_sign_up)
public class SignUp extends AppCompatActivity {

    //Variables
    Realm realm;

    //Register
    @ViewById
    EditText register_name;

    @ViewById
    EditText register_pass;

    @ViewById
    EditText register_confirm;

    @ViewById
    Button signup_apply;

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
        realm = Realm.getDefaultInstance();
    }

    @Click
    public void signup_apply()
    {
        String user = register_name.getText().toString();
        String pass = register_pass.getText().toString();
        String passC = register_confirm.getText().toString();

        if (user.equals("")) //Name cannot be blank
        {
            Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
        }
        else if(pass.equals("") && passC.equals("")) //Password cannot be blank
        {
            Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_SHORT).show();
        }
        else if (!pass.equals(passC)) //Password should match
        {
            Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Find the object if it's in the database...[this returns a null if none]
            User result = realm.where(User.class)
                               .equalTo("name", user)
                               .findFirst();

            //Allow the user to register if the credentials are unique
            if (result != null) //If it's in the database
            {
                Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
            }
            else //This assumes that the returned value is null
            {
                //Create a new object
                User newUser = new User();
                newUser.setUuid(UUID.randomUUID().toString());
                newUser.setName(user);
                newUser.setPass(pass);

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(newUser);
                realm.commitTransaction();

                //Saved!
                Toast.makeText(this, "New User saved", Toast.LENGTH_SHORT).show();
                finish();
            }
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