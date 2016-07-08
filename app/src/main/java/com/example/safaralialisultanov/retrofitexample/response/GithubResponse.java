package com.example.safaralialisultanov.retrofitexample.response;

import android.content.Context;

import com.example.safaralialisultanov.retrofitexample.GithubUser;
import com.example.safaralialisultanov.retrofitexample.database.RealmBase;

import io.realm.Realm;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public class GithubResponse extends Response {

    /* Реализация метода save, описанного в базовом классе Response*/

    @Override
    public void save(Context context) {
        GithubUser usr = getTypedAnswer();
        if (usr != null) {
            RealmBase.save(Realm.getInstance(context), usr);
        }
    }
}
