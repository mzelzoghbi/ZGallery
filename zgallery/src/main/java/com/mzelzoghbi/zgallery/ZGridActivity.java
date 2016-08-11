package com.mzelzoghbi.zgallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/6/16.
 */
public final class ZGridActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private GridImagesAdapter adapter;
    private ArrayList<String> imageURLs;
    private String title;
    private int spanCount = 2;
    private int toolbarColorResId;
    private int imgPlaceHolderResId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // get values
        imageURLs = getIntent().getStringArrayListExtra(Constants.IntentPassingParams.IMAGES);
        spanCount = getIntent().getIntExtra(Constants.IntentPassingParams.COUNT, 2);
        toolbarColorResId = getIntent().getIntExtra(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, -1);
        imgPlaceHolderResId = getIntent().getIntExtra(Constants.IntentPassingParams.IMG_PLACEHOLDER, -1);
        title = getIntent().getStringExtra(Constants.IntentPassingParams.TITLE);

        if (getSupportActionBar() == null) {
            setSupportActionBar(mToolbar);
            mToolbar.setVisibility(View.VISIBLE);
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

        adapter = new GridImagesAdapter(this, imageURLs, imgPlaceHolderResId);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
