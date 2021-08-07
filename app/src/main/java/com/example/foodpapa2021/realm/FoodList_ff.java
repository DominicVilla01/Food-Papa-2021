package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FoodList_ff extends RealmObject
{
    @PrimaryKey
    private String uuid;

    private String ff_name;
    private String ff_price;
    private String ff_quantity;

    public FoodList_ff()
    {
    }

    public FoodList_ff(String uuid, String ff_name, String ff_price, String ff_quantity) {
        this.uuid = uuid;
        this.ff_name = ff_name;
        this.ff_price = ff_price;
        this.ff_quantity = ff_quantity;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFf_name() {
        return ff_name;
    }

    public void setFf_name(String ff_name) {
        this.ff_name = ff_name;
    }

    public String getFf_price() {
        return ff_price;
    }

    public void setFf_price(String ff_price) {
        this.ff_price = ff_price;
    }

    public String getFf_quantity() {
        return ff_quantity;
    }

    public void setFf_quantity(String ff_quantity) {
        this.ff_quantity = ff_quantity;
    }

    @Override
    public String toString() {
        return "FoodList_ff{" +
                "uuid='" + uuid + '\'' +
                ", ff_name='" + ff_name + '\'' +
                ", ff_price='" + ff_price + '\'' +
                ", ff_quantity='" + ff_quantity + '\'' +
                '}';
    }
}