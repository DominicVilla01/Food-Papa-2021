package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RestaurantList extends RealmObject {

    @PrimaryKey

    private String uuid;

    private String res_name;
    private String res_rating;
    private String res_time_distance;

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRes_name() {return res_name;}
    public void setRes_name(String res_name) {this.res_name = res_name;}

    public String getRes_rating() {return res_rating;}
    public void setRes_rating(String res_rating) {this.res_rating = res_rating;}

    public String getRes_time_distance() {return res_time_distance;}
    public void setRes_time_distance(String res_time_distance) {this.res_time_distance = res_time_distance;}
    
    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", res_name='" + res_name + '\'' +
                ", res_rating='" + res_rating + '\'' +
                ", res_time_distance='" + res_time_distance + '\'' +
                '}';
    }
}
