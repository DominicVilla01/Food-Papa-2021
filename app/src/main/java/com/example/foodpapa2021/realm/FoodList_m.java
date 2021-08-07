package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FoodList_m extends RealmObject{

    @PrimaryKey

    private String uuid;

    private String m_name;
    private int m_price;
    private int m_quantity;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_price() {
        return m_price;
    }

    public void setM_price(int m_price) {
        this.m_price = m_price;
    }

    public int getM_quantity() {
        return m_quantity;
    }

    public void setM_quantity(int m_quantity) {
        this.m_quantity = m_quantity;
    }

    @Override
    public String toString() {
        return "FoodList_m{" +
                "uuid='" + uuid + '\'' +
                ", m_name='" + m_name + '\'' +
                ", m_price=" + m_price +
                ", m_quantity=" + m_quantity +
                '}';
    }
}
