package com.example.android.ymediacoding.ui.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ymediacoding.DaggerFollowersComponent;
import com.example.android.ymediacoding.DaggerMainComponent;
import com.example.android.ymediacoding.FollowersModule;
import com.example.android.ymediacoding.R;
import com.example.android.ymediacoding.model.User;
import com.example.android.ymediacoding.ui.followers.FollowersActivity;
import com.example.android.ymediacoding.ui.main.MainContract;
import com.example.android.ymediacoding.util.GitHubLookupUtility;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindFloat;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @Inject GitHubLookupUtility gitHubLookupUtility;

    @BindView(R.id.img_icon) ImageView imgIcon;
    @BindView(R.id.text_login) TextView tvLogin;
    @BindView(R.id.text_name) TextView tvName;
    @BindView(R.id.text_followers_count) TextView tvFollowersCount;
    @BindView(R.id.text_following_count) TextView tvFollowingCOunt;
    @BindView(R.id.text_repos_count) TextView tvRepoCount;
    @BindView(R.id.text_location) TextView tvLocation;
    @BindView(R.id.text_email) TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        DaggerFollowersComponent.builder()
                .followersModule(new FollowersModule(DetailActivity.this))
                .build()
                .inject(DetailActivity.this);

        Intent info = getIntent();
        String user = info.getStringExtra("user");

        Observer<User> userObserver = new Observer<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                showError(e.getMessage());
            }

            @Override
            public void onNext(User user) {
                Picasso.with(DetailActivity.this).load(user.getAvatarUrl()).into(imgIcon);
                tvLogin.setText(user.getLogin());
                tvName.setText(user.getName());
                tvFollowersCount.setText((user.getFollowers()).toString() == null ? "0" : user.getFollowers().toString());
                tvFollowingCOunt.setText(user.getFollowing().toString() == null ? "0" : user.getFollowing().toString());
                tvRepoCount.setText(user.getPublicRepos().toString() == null ? "0" : user.getPublicRepos().toString());
                tvLocation.setText(user.getLocation().toString());
                tvEmail.setText(user.getEmail().toString());
            }
        };

        Subscription subscription = gitHubLookupUtility.getService().getUser(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userObserver);
    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String string) {

    }
}
