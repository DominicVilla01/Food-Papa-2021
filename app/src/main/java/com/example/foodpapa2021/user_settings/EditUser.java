package com.example.foodpapa2021.user_settings;import androidx.appcompat.app.AppCompatActivity;import android.content.SharedPreferences;import android.os.Bundle;import android.widget.Button;import android.widget.EditText;import android.widget.Toast;import com.example.foodpapa2021.OrderPage_;import com.example.foodpapa2021.R;import com.example.foodpapa2021.realm.User;import org.androidannotations.annotations.AfterViews;import org.androidannotations.annotations.Click;import org.androidannotations.annotations.EActivity;import org.androidannotations.annotations.ViewById;import io.realm.Realm;@EActivity(R.layout.activity_edit_user)public class EditUser extends AppCompatActivity {    //variables    Realm realm;    @ViewById    EditText edit_name;    @ViewById    EditText edit_pass;    @ViewById    EditText edit_confirm;    @ViewById    Button edit_apply;    @AfterViews    public void init()    {        realm = Realm.getDefaultInstance();        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);        String uuid = prefs.getString("uuid", null);        User userInfo = realm.where(User.class).equalTo("uuid", uuid).findFirst();        if (userInfo != null)        {            edit_name.setText(userInfo.getName());            edit_pass.setText(userInfo.getPass());            edit_confirm.setText(userInfo.getPass());        }    }    @Click    public void edit_apply()    {        String user = edit_name.getText().toString();        String pass = edit_pass.getText().toString();        String passC = edit_confirm.getText().toString();        if(user.equals(""))        {            Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();        }        else if(pass.equals("") && passC.equals("")) //Password cannot be blank        {            Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_SHORT).show();        }        else if(!pass.equals(passC))        {            Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_SHORT).show();        }        else {            SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);            String uuid = prefs.getString("uuid", null);            User result = realm.where(User.class)                    .equalTo("name", user)                    .findFirst();            User userInfo = realm.where(User.class).equalTo("uuid", uuid).findFirst();            if (user.equals(userInfo.getName())) {                realm.beginTransaction();                userInfo.setName(user);                userInfo.setPass(pass);                realm.commitTransaction();                //Saved!                Toast.makeText(this, "Edit saved", Toast.LENGTH_SHORT).show();                OrderPage_.intent(this).start();            }            else if(result == null && pass.equals(passC)) {                realm.beginTransaction();                userInfo.setName(user);                userInfo.setPass(pass);                realm.commitTransaction();                //Saved!                Toast.makeText(this, "Edit saved", Toast.LENGTH_SHORT).show();                OrderPage_.intent(this).start();            }            else if (result != null) {                Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();            }        }    }    public void onDestroy()    {        super.onDestroy();        if (!realm.isClosed())        {            realm.close();        }    }}