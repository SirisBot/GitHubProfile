package com.example.android.ymediacoding.util;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Siris on 2/21/2017.
 */

public class GitHubLookupUtility {

    private static final String BASE_URL = "https://api.github.com";

    GitHubService service;

    public GitHubLookupUtility(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GitHubService.class);
    }

    public GitHubService getService() {
        return service;
    }
}
