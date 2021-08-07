package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FoodList extends RealmObject {
//    Set Vars
    @PrimaryKey
    private String uuid;

    private String food_name;
    private String food_price;
    private String food_quantity;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_quantity() {
        return food_quantity;
    }

    public void setFood_quantity(String food_quantity) {
        this.food_quantity = food_quantity;
    }

    @Override
    public String toString() {
        return "FoodList{" +
                "uuid='" + uuid + '\'' +
                ", food_name='" + food_name + '\'' +
                ", food_price='" + food_price + '\'' +
                ", food_quantity='" + food_quantity + '\'' +
                '}';
    }
}
