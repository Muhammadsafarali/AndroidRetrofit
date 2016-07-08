package com.example.safaralialisultanov.retrofitexample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.safaralialisultanov.retrofitexample.response.GithubResponse;
import com.example.safaralialisultanov.retrofitexample.response.GithubUserAPI;
import com.example.safaralialisultanov.retrofitexample.response.RequestResult;
import com.example.safaralialisultanov.retrofitexample.response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
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
    protected Response apiCall() throws IOException {

        GithubUserAPI service = ApiFactory.getGithubService();
        Call<GithubUser> call = service.getUser("Muhammadsafarali");
        GithubUser usr = call.execute().body();
        return new GithubResponse()
                .setRequestResult(RequestResult.SUCCESS)
                .setAnswer(usr);
    }
}
