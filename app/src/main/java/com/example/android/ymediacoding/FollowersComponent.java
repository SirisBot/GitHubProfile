package com.example.android.ymediacoding;

import com.example.android.ymediacoding.ui.detail.DetailActivity;
import com.example.android.ymediacoding.ui.followers.FollowersActivity;

import dagger.Component;
import dagger.Module;

/**
 * Created by Siris on 2/21/2017.
 */

@Component(modules = FollowersModule.class)
public interface FollowersComponent {
    void inject(FollowersActivity followersActivity);

    void inject (DetailActivity detailActivity);
}
