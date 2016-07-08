package com.example.safaralialisultanov.retrofitexample;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.io.IOException;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public abstract class BaseLoader extends AsyncTaskLoader<GithubUser> {

    final String LOG_TAG = "myLogs";

    public BaseLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.e(LOG_TAG, hashCode() + " onStartLoading");
        forceLoad();
    }

    @Override
    public GithubUser loadInBackground() {
        try {
            GithubUser response = apiCall();


            Log.e(LOG_TAG, this.hashCode() + " doInBackground");
            return response;
        }
        catch (IOException e) {
            onError();
            return new GithubUser();
        }
    }

    protected void onSuccess() {

    }

    protected void onError() {

        Log.e(LOG_TAG, "Error------------------");
    }

    protected abstract GithubUser apiCall() throws IOException;
}
