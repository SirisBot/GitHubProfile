package com.example.android.ymediacoding.ui.main;

import com.example.android.ymediacoding.ui.BasePresenter;
import com.example.android.ymediacoding.ui.BaseView;

/**
 * Created by Siris on 2/20/2017.
 */

public interface MainContract {
    interface View extends BaseView {
        void showData(String data);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData();
    }
}
