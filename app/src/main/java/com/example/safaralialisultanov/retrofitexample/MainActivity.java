package com.example.safaralialisultanov.retrofitexample;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Streams;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<GithubUser> {

    final String LOG_TAG = "myLogs";
    static final int LOADER_ID = 1;
    TextView txbHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txbHello = (TextView)findViewById(R.id.txbHello);

        Bundle bndl = new Bundle();
        getLoaderManager().initLoader(LOADER_ID, bndl.EMPTY, this);
    }

    public void onClick(View view) {

//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(GithubUserAPI.ENPOINT)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        GithubUserAPI githubUserAPI = retrofit.create(GithubUserAPI.class);
//
//        Call<GithubUser> call = githubUserAPI.getUser("Muhammadsafarali");
//        //asynch call
//       // call.enqueue(this);
//        try
//        {
//            GithubUser usr = call.execute().body();
//        }
//        catch (IOException e) {
//            Log.d(LOG_TAG, "error: " + e.toString());
//        }
    }


    @Override
    public Loader<GithubUser> onCreateLoader(int id, Bundle args) {

        Loader<GithubUser> loader = null;
        if (id == LOADER_ID) {
            loader = new HTTPLoader(this, args);
            Log.e(LOG_TAG, "onCreateLoader: " + loader.hashCode());
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<GithubUser> loader, GithubUser result) {
        Log.e(LOG_TAG, "onLoaderFinished for loader " + loader.hashCode() + ", result = " + result.login);
        txbHello.setText(result.login);
    }

    @Override
    public void onLoaderReset(Loader<GithubUser> loader) {
        Log.e(LOG_TAG, "onLoaderReset for loader " + loader.hashCode());
    }
}
