package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CategoryList extends RealmObject {

    @PrimaryKey
    private String uuid;

    private String cat_name;
    private String cat_rating;
    private String cat_time_distance;
    private String cat_cat;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_rating() {
        return cat_rating;
    }

    public void setCat_rating(String cat_rating) {
        this.cat_rating = cat_rating;
    }

    public String getCat_time_distance() {
        return cat_time_distance;
    }

    public void setCat_time_distance(String cat_time_distance) {
        this.cat_time_distance = cat_time_distance;
    }

    public String getCat_cat() {
        return cat_cat;
    }

    public void setCat_cat(String cat_cat) {
        this.cat_cat = cat_cat;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "uuid='" + uuid + '\'' +
                ", cat_name='" + cat_name + '\'' +
                ", cat_rating='" + cat_rating + '\'' +
                ", cat_time_distance='" + cat_time_distance + '\'' +
                ", cat_cat='" + cat_cat + '\'' +
                '}';
    }
}
