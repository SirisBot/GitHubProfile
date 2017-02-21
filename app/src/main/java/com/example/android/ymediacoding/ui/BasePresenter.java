package com.example.android.ymediacoding.ui;

/**
 * Created by Siris on 2/20/2017.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);

    void detachView();
}
