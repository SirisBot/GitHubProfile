package com.example.android.ymediacoding.ui.followers;

import com.example.android.ymediacoding.ui.BaseView;

/**
 * Created by Siris on 2/21/2017.
 */

public class FollowersPresenter implements FollowersContract.Presenter {

    FollowersContract.View view;

    @Override
    public void loadData() {
        view.showProgress();
        view.showData("Hello");
        view.hideProgress();
    }

    @Override
    public void attachView(FollowersContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
