package com.example.safaralialisultanov.retrofitexample;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public class HTTPLoader extends BaseLoader {

    final String LOG_TAG = "myLogs";


    public HTTPLoader(Context context, Bundle args) {
        super(context);
        Log.e(LOG_TAG, hashCode() + " create HTTPAsynchLoader");
    }


    @Override
    protected GithubUser apiCall() throws IOException {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubUserAPI.ENPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GithubUserAPI service = retrofit.create(GithubUserAPI.class);
        Call<GithubUser> call = service.getUser("Muhammadsafarali");
        GithubUser usr = null;
        try
        {
            usr = call.execute().body();
            Log.e(LOG_TAG, "result user login: " + usr.login);
        }
        catch (IOException e) {
            Log.e(LOG_TAG, "error: " + e.toString());
        }

        return usr;
    }

//    @Override
//    public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
//
//        int code = response.code();
//        if (code == 200) {
//            GithubUser user = response.body();
////            Toast.makeText(this, "Got the user: " + user.name, Toast.LENGTH_LONG).show();
//            Log.d(LOG_TAG, "Got the user: " + user.name + ". Here login: " + user.login);
//        }
//        else {
////            Toast.makeText(this, "Did not work: " + String. valueOf(code),
////                    Toast.LENGTH_LONG).show();
//            Log.d(LOG_TAG, "Did not work: " + String.valueOf(code));
//        }
//    }

//    @Override
//    public void onFailure(Call<GithubUser> call, Throwable t) {
////        Toast.makeText(this, "Nope", Toast.LENGTH_LONG).show();
//        Log.d(LOG_TAG, "Nope");
//    }
}
