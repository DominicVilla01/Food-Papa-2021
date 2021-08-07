package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OrderList extends RealmObject
{
    @PrimaryKey
    private String uuid;
    private String order_name;
    private int order_price;
    private int order_quantity;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "uuid='" + uuid + '\'' +
                ", order_name='" + order_name + '\'' +
                ", order_price=" + order_price +
                ", order_quantity=" + order_quantity +
                '}';
    }
}
