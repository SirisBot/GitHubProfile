package com.example.android.ymediacoding;

import android.content.Context;

import com.example.android.ymediacoding.model.Follower;
import com.example.android.ymediacoding.util.GitHubLookupUtility;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Siris on 2/21/2017.
 */

@Module
public class FollowersModule {

    private Context context;

    public FollowersModule(Context context) {
        this.context = context;
    }

    @Provides
    GitHubLookupUtility provideGitHubUtility() {
        return new GitHubLookupUtility(context);
    }
}
