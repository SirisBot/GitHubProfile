package com.example.android.ymediacoding.util;

import com.example.android.ymediacoding.model.Follower;
import com.example.android.ymediacoding.model.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Siris on 2/21/2017.
 */

public interface GitHubService {

    @GET("/users/{username}/followers")
    Observable<List<Follower>> getFollowers(@Path("username") String user);

    @GET("users/{username}")
    Observable<User> getUser(@Path("username") String user);
}
