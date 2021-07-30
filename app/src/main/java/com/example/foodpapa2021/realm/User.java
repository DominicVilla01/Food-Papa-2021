package com.example.foodpapa2021.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey
    private String uuid;

    private String name;
    private String pass;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
