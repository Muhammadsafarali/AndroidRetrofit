package com.example.safaralialisultanov.retrofitexample;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public class GithubUser {

    String login;
    String name;

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

    @Override
    public String toString() {
        return(login);
    }
}
