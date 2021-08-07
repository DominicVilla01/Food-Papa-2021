package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodpapa2021.adapters.CategoryAdapter;
import com.example.foodpapa2021.adapters.RestaurantAdapter;
import com.example.foodpapa2021.realm.CategoryList;
import com.example.foodpapa2021.realm.RestaurantList;
import com.example.foodpapa2021.realm.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_category_page)
public class CategoryPage extends AppCompatActivity {
//    Set Variables
    SharedPreferences prefs;
    Realm realm;

//    Get Views
    @ViewById
    ImageView cat_page_img;

    @ViewById
    TextView cat_page_title;

    @ViewById
    RecyclerView cat_page_restaurantList;


//    Manage data
    @AfterViews
    public void init() {

        realm = Realm.getDefaultInstance();
//        Retrieve user choice
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        String choice = prefs.getString("OrderClick", null);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        cat_page_restaurantList.setLayoutManager(mLayoutManager);

        RealmResults<CategoryList> list = realm.where(CategoryList.class).equalTo("cat_cat", choice).findAll();
        CategoryAdapter catAdapter = new CategoryAdapter(this,list,true);
        cat_page_restaurantList.setAdapter(catAdapter);


        //        Process user choice
        processClick(choice);
    }


//    Function for processing category choice
    public void processClick(String click_option)
    {
        if(click_option.equals("Fast Food"))
        {
            cat_page_title.setText("Category: Fast Food");
            cat_page_img.setImageResource(R.drawable.fast_food);
        }
        else if(click_option.equals("Milk Tea"))
        {
            cat_page_title.setText("Category: Milk Tea");
            cat_page_img.setImageResource(R.drawable.milktea);
        }
        else if(click_option.equals("Fast-Casual"))
        {
            cat_page_title.setText("Category: Fast-Casual");
            cat_page_img.setImageResource(R.drawable.fast_casual);
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
    public void catObj(CategoryList cat)
    {
        prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("res_name", cat.getCat_name());
        edit.apply();

        RestaurantPage_.intent(this).start();
    }
}