package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FoodList_m extends RealmObject {

    @PrimaryKey

    private String uuid;

    private String m_name1;
    private String m_name2;
    private String m_name3;
    private String m_name4;

    private String m_price1;
    private String m_price2;
    private String m_price3;
    private String m_price4;

    private Integer m_quantity1;
    private Integer m_quantity2;
    private Integer m_quantity3;
    private Integer m_quantity4;
    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getM_name1() {
        return m_name1;
    }

    public void setM_name1(String m_name1) {
        this.m_name1 = m_name1;
    }

    public String getM_name2() {
        return m_name2;
    }

    public void setM_name2(String m_name2) {
        this.m_name2 = m_name2;
    }

    public String getM_name3() {
        return m_name3;
    }

    public void setM_name3(String m_name3) {
        this.m_name3 = m_name3;
    }

    public String getM_name4() {
        return m_name4;
    }

    public void setM_name4(String m_name4) {
        this.m_name4 = m_name4;
    }

    public String getM_price1() {
        return m_price1;
    }

    public void setM_price1(String m_price1) {
        this.m_price1 = m_price1;
    }

    public String getM_price2() {
        return m_price2;
    }

    public void setM_price2(String m_price2) {
        this.m_price2 = m_price2;
    }

    public String getM_price3() {
        return m_price3;
    }

    public void setM_price3(String m_price3) {
        this.m_price3 = m_price3;
    }

    public String getM_price4() {
        return m_price4;
    }

    public void setM_price4(String m_price4) {
        this.m_price4 = m_price4;
    }

    public Integer getM_quantity1() {
        return m_quantity1;
    }

    public void setM_quantity1(Integer m_quantity1) {
        this.m_quantity1 = m_quantity1;
    }

    public Integer getM_quantity2() {
        return m_quantity2;
    }

    public void setM_quantity2(Integer m_quantity2) {
        this.m_quantity2 = m_quantity2;
    }

    public Integer getM_quantity3() {
        return m_quantity3;
    }

    public void setM_quantity3(Integer m_quantity3) {
        this.m_quantity3 = m_quantity3;
    }

    public Integer getM_quantity4() {
        return m_quantity4;
    }

    public void setM_quantity4(Integer m_quantity4) {
        this.m_quantity4 = m_quantity4;
    }



}
