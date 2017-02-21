package com.example.android.ymediacoding.ui.followers;

import com.example.android.ymediacoding.ui.BasePresenter;
import com.example.android.ymediacoding.ui.BaseView;

/**
 * Created by Siris on 2/21/2017.
 */

public interface FollowersContract {

    interface View extends BaseView {
        void showData(String data);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData();
    }
}
