package com.example.android.ymediacoding;

import com.example.android.ymediacoding.ui.detail.DetailActivity;
import com.example.android.ymediacoding.ui.followers.FollowersActivity;
import com.example.android.ymediacoding.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Siris on 2/20/2017.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
