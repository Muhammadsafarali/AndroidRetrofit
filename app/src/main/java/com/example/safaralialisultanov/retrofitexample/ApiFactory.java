package com.example.safaralialisultanov.retrofitexample;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.safaralialisultanov.retrofitexample.response.GithubUserAPI;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.realm.RealmObject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public class ApiFactory {

    static final String LOG_TAG = "myLogs";

    private static final Gson GSON = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .create();

    @NonNull
    public static GithubUserAPI getGithubService() {

        Log.e(LOG_TAG, "create GithubUserAPI in ApiFactory");
        return getRetrofit().create(GithubUserAPI.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {

        Log.e(LOG_TAG, "create Retrofit in ApiFactory");
        return new Retrofit.Builder()
                .baseUrl(GithubUserAPI.ENPOINT)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build();
    }
}
