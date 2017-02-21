package com.example.android.ymediacoding;

import android.content.Context;

import com.example.android.ymediacoding.util.GitHubLookupUtility;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Siris on 2/20/2017.
 */

@Module
public class MainModule {

    Context context;

    public MainModule(Context context) {
        this.context = context;
    }
}
