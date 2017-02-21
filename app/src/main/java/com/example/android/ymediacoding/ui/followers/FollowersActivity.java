package com.example.android.ymediacoding.ui.followers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.ymediacoding.DaggerFollowersComponent;
import com.example.android.ymediacoding.FollowersModule;
import com.example.android.ymediacoding.MainModule;
import com.example.android.ymediacoding.R;
import com.example.android.ymediacoding.model.Follower;
import com.example.android.ymediacoding.ui.detail.DetailActivity;
import com.example.android.ymediacoding.ui.main.MainContract;
import com.example.android.ymediacoding.util.GitHubLookupUtility;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FollowersActivity extends AppCompatActivity implements FollowersContract.View, OnItemClickListener {

    private static final String TAG = "FollowersTAG";

    private List<Follower> followerList;

    @Inject GitHubLookupUtility gitHubLookupUtility;

    @BindView(R.id.recycler_view_followers)
    RecyclerView rvFollowers;

    @BindView(R.id.prg_followers)
    ProgressBar prgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        ButterKnife.bind(FollowersActivity.this);

        followerList = new ArrayList<Follower>();

        DaggerFollowersComponent.builder()
                .followersModule(new FollowersModule(FollowersActivity.this))
                .build()
                .inject(FollowersActivity.this);

        showProgress();

        Intent info = getIntent();
        String user = info.getStringExtra("username");

        Observer<List<Follower>> followers = new Observer<List<Follower>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                showError(e.getMessage());
            }

            @Override
            public void onNext(List<Follower> followers) {

                followerList = followers;
                FollowersAdapter followersAdapter = new FollowersAdapter(FollowersActivity.this, followers, FollowersActivity.this);

                rvFollowers.setLayoutManager(new GridLayoutManager(FollowersActivity.this, 3));
                rvFollowers.setAdapter(followersAdapter);

                hideProgress();
            }
        };

        Subscription subscription = gitHubLookupUtility.getService().getFollowers(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(followers);
    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showProgress() {
        rvFollowers.setVisibility(View.INVISIBLE);
        prgBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        prgBar.setVisibility(View.INVISIBLE);
        rvFollowers.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String string) {
        Log.d(TAG, "showError: " + string);
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int item) {
        Follower follower = followerList.get(item);
        String user = follower.getLogin();
        Intent intent = new Intent(FollowersActivity.this, DetailActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
