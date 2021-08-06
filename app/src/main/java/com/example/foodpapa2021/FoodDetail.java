package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_food_detail)
public class FoodDetail extends AppCompatActivity {
    //variables
    int quantity = 1;

    @ViewById
    ImageView food_detail_add;

    @ViewById
    ImageView food_detail_subtract;

    @ViewById
    ImageView food_detail_foodimg;

    @ViewById
    TextView food_detail_quantity;

    @ViewById
    Button food_detail_updateBasket;

    @AfterViews
    public void init(){
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_add(){
        quantity++;
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_subtract(){
        quantity--;
        if(quantity>0)
        {
            food_detail_quantity.setText(String.valueOf(quantity));
        }
        else if(quantity < 0){
            quantity = 0;
            food_detail_quantity.setText(String.valueOf(quantity));
        }
    }

    @Click
    public void food_detail_updateBasket(){

        // fast food
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_chicken);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_chicwdrink);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_fries);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_sundae);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_chicken);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_chicwdrink);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_fries);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_sundae);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_chicken);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_chicwdrink);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_fries);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_sundae);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_popeyes_chicken);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_popeyes_fries);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_popeyes_sundae);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_wendys_chicwdrink);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_wendys_fries);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_wendys_sundae);

        // milk tea

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tigersugar_black);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tigersugar_sugar);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_black);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_classic);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_pearl);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_sugar);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_black);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_classic);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_pearl);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_sugar);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_macao_classic);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_macao_pearl);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_macao_sugar);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_serenitea_classic);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_serenitea_pearl);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_serenitea_sugar);

        // casual

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_italiannis_salad);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_itallianis_pasta);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_itallianis_ribs);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_icedtea);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_pasta);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_ribs);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_salad);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_racks_pasta);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_racks_ribs);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_racks_salad);

        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_icedtea);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_pasta);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_ribs);
        food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_salad);
    }

}