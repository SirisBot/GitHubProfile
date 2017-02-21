package com.example.android.ymediacoding.ui.detail;

/**
 * Created by Siris on 2/21/2017.
 */

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;

    @Override
    public void loadData() {
        view.showProgress();
        view.showData("Hello");
        view.hideProgress();
    }

    @Override
    public void attachView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
