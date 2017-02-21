package com.example.android.ymediacoding.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.ymediacoding.R;
import com.example.android.ymediacoding.model.Follower;
import com.example.android.ymediacoding.ui.followers.FollowersActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_main_username)
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);
    }

    @OnClick(R.id.btn_main_search)
    public void search() {
        String user = etUsername.getText().toString();
        if (!user.equals("")) {
            Intent intent = new Intent(MainActivity.this, FollowersActivity.class);
            intent.putExtra("username", user);
            startActivity(intent);
        }
    }
}
