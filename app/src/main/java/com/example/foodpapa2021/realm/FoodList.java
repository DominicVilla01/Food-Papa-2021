package com.example.foodpapa2021.realm;

import io.realm.RealmObject;

public class FoodList extends RealmObject {
//    Set Vars
    String uuid;
    String food_name;
    String food_price;
    String food_quantity;


//    Get Methods
    public String getUuid() {return this.uuid;}
    public String getFood_name() {return this.food_name;}
    public String getFood_price() {return this.food_price;}
    public String getFood_quantity() {return this.food_quantity;}


//    Setter Methods
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public void setFood_quantity(String food_quantity) {
        this.food_quantity = food_quantity;
    }


//    To String
    public String toString() {
        return "FoodList{" +
                "uuid='" + uuid + "\'" +
                "food_name='" + food_name + "\'" +
                "food_price='" + food_price + "\'" +
                "food_quantity='" + food_quantity + "\'" +
                "}";
    }
}
