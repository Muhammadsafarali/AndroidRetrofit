package com.example.safaralialisultanov.retrofitexample;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safaralialisultanov.retrofitexample.response.Response;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response> {

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
    public Loader<Response> onCreateLoader(int id, Bundle args) {

        Loader<Response> loader = null;
        if (id == LOADER_ID) {
            loader = new HTTPLoader(this, args);
            Log.e(LOG_TAG, "onCreateLoader: " + loader.hashCode());
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response result) {
        Log.e(LOG_TAG, "onLoaderFinished for loader " + loader.hashCode());
        int id = loader.getId();
        if (id == LOADER_ID) {
            GithubUser data = result.getTypedAnswer();
            if (data != null)
                txbHello.setText("LOGIN: " + data.getLogin());
        }
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {
        Log.e(LOG_TAG, "onLoaderReset for loader " + loader.hashCode());
    }
}
