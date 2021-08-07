package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FoodList_fc extends RealmObject {
    @PrimaryKey
    private String uuid;

    private String fc_name;
    private double fc_price;
    private int fc_quantity;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFc_name() {
        return fc_name;
    }

    public void setFc_name(String fc_name) {
        this.fc_name = fc_name;
    }

    public double getFc_price() {
        return fc_price;
    }

    public void setFc_price(double fc_price) {
        this.fc_price = fc_price;
    }

    public int getFc_quantity() {
        return fc_quantity;
    }

    public void setFc_quantity(int fc_quantity) {
        this.fc_quantity = fc_quantity;
    }

    @Override
    public String toString() {
        return "FoodList_fc{" +
                "uuid='" + uuid + '\'' +
                ", fc_name='" + fc_name + '\'' +
                ", fc_price=" + fc_price +
                ", fc_quantity=" + fc_quantity +
                '}';
    }
}
