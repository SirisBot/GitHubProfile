package com.example.android.ymediacoding.ui.main;

/**
 * Created by Siris on 2/21/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    @Override
    public void loadData() {
        view.showProgress();
        view.showData("Data");
        view.hideProgress();
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
