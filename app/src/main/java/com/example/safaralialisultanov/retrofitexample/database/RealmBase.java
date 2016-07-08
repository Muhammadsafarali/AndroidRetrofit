package com.example.safaralialisultanov.retrofitexample.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.safaralialisultanov.retrofitexample.GithubUser;

import java.util.List;

import io.realm.Realm;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public class RealmBase {

    static final String LOG_TAG = "myLogs";

    public static void save(@NonNull Realm realm, GithubUser users) {

        Log.e(LOG_TAG, "save in RealmBase");
        realm.beginTransaction();
        realm.clear(GithubUser.class);
        realm.copyToRealm(users);
        realm.commitTransaction();
    }
}
