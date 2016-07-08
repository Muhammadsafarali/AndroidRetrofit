package com.example.safaralialisultanov.retrofitexample;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.safaralialisultanov.retrofitexample.response.RequestResult;
import com.example.safaralialisultanov.retrofitexample.response.Response;

import java.io.IOException;

/**
 * Created by safarali.alisultanov on 08.07.2016.
 */
public abstract class BaseLoader extends AsyncTaskLoader<Response> {

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
    public Response loadInBackground() {
        try {
            Log.e(LOG_TAG, this.hashCode() + " doInBackground");
            Response response = apiCall();
            if (response.getRequestResult() == RequestResult.SUCCESS) {
                response.save(getContext());
                onSuccess();
            }
            else {
                onError();
            }
            return response;
        }
        catch (IOException e) {
            onError();
            return new Response();
        }
    }

    protected void onSuccess() {
        Log.e(LOG_TAG, "Success------------------");
    }

    protected void onError() {

        Log.e(LOG_TAG, "Error------------------");
    }

    protected abstract Response apiCall() throws IOException;
}
