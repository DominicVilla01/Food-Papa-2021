package com.example.foodpapa2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodpapa2021.realm.FoodList_fc;
import com.example.foodpapa2021.realm.RestaurantList;

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
    public void init() {
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_add() {
        quantity++;
        food_detail_quantity.setText(String.valueOf(quantity));
    }

    @Click
    public void food_detail_subtract() {
        quantity--;
        if (quantity > 0) {
            food_detail_quantity.setText(String.valueOf(quantity));
        } else if (quantity < 0) {
            quantity = 0;
            food_detail_quantity.setText(String.valueOf(quantity));
        }
    }

    @Click
    public void food_detail_updateBasket() {

        // fast food
//        if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_chicken);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_chicwdrink);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_fries);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_jollibee_sundae);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_chicken);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_chicwdrink);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_fries);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_kfc_sundae);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_chicken);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_chicwdrink);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_fries);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_mcdo_sundae);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_popeyes_chicken);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_popeyes_fries);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_popeyes_sundae);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_wendys_chicwdrink);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_wendys_fries);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_wendys_sundae);
//        }
//
//        // milk tea
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tigersugar_black);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tigersugar_sugar);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_black);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_classic);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_pearl);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_coco_sugar);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_black);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_classic);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_pearl);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_gongcha_sugar);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_macao_classic);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_macao_pearl);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_macao_sugar);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_serenitea_classic);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_serenitea_pearl);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_serenitea_sugar);
//        }
//
//        // casual
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_italiannis_salad);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_itallianis_pasta);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_itallianis_ribs);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_icedtea);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_pasta);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_ribs);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_outback_salad);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_racks_pasta);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_racks_ribs);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_racks_salad);
//        }
//
//        else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_icedtea);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_pasta);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_ribs);
//        } else if () {
//            food_detail_foodimg.setImageResource(R.drawable.foodlist_img_tgif_salad);
//        }

    }
}