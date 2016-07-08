package com.example.safaralialisultanov.retrofitexample;

import com.example.safaralialisultanov.retrofitexample.database.RealmBase;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public class GithubUser extends RealmObject {

    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String  name;

    public GithubUser() {
    }

    public GithubUser(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
