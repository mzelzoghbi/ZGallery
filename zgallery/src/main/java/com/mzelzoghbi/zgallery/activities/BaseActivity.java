package com.mzelzoghbi.zgallery.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.R;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/11/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected ArrayList<String> imageURLs;
    protected ZColor toolbarTitleColor;
    protected int toolbarColorResId;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayoutId());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        // get values
        imageURLs = getIntent().getStringArrayListExtra(Constants.IntentPassingParams.IMAGES);
        toolbarColorResId = getIntent().getIntExtra(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, -1);
        title = getIntent().getStringExtra(Constants.IntentPassingParams.TITLE);
        toolbarTitleColor = (ZColor) getIntent().getSerializableExtra(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR);

        if (getSupportActionBar() == null) {
            setSupportActionBar(mToolbar);
            mToolbar.setVisibility(View.VISIBLE);
            if (toolbarTitleColor == ZColor.BLACK) {
                mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.black));
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);
            } else {
                mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
            }
            mToolbar.setBackgroundColor(getResources().getColor(toolbarColorResId));
            if (title != null) {
                getSupportActionBar().setTitle(title);
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } else {
            mToolbar.setVisibility(View.GONE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        afterInflation();
    }


    protected abstract int getResourceLayoutId();

    protected abstract void afterInflation();
}
