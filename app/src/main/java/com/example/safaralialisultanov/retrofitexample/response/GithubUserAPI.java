package com.example.safaralialisultanov.retrofitexample.response;

import com.example.safaralialisultanov.retrofitexample.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public interface GithubUserAPI {

    String ENPOINT = "https://api.github.com";

    @GET("/users/{user}")
    Call<GithubUser> getUser(@Path("user") String user);
}
