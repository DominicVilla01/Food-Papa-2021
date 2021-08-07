package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FoodList_fc extends RealmObject {
    @PrimaryKey
    private String uuid;

    private String fc_name;
    private String fc_price;

    private Integer fc_quantity;

//    Get methods

    public String getUuid() {
        return uuid;
    }

    public String getFc_name() {
        return fc_name;
    }

    public String getFc_price() {
        return fc_price;
    }

    public Integer getFc_quantity() {
        return fc_quantity;
    }

//    Set methods

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFc_name(String fc_name) {
        this.fc_name = fc_name;
    }

    public void setFc_price(String fc_price) {
        this.fc_price = fc_price;
    }

    public void setFc_quantity(Integer fc_quantity) {
        this.fc_quantity = fc_quantity;
    }

//    To String
    @Override
    public String toString() {
        return "FoodList_fc{" +
                "uuid='" + uuid + '\'' +
                ", fc_name='" + fc_name + '\'' +
                ", fc_price='" + fc_price + '\'' +
                ", fc_quantity=" + fc_quantity +
                '}';
    }
}