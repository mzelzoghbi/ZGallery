package com.mzelzoghbi.zgallery.activities;

import android.view.MenuItem;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.R;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.adapters.GridImagesAdapter;
import com.mzelzoghbi.zgallery.adapters.listeners.GridClickListener;
import com.mzelzoghbi.zgallery.entities.ZColor;

/**
 * Created by mohamedzakaria on 8/6/16.
 *
 * Modified by mirjalal on 16/11/20.
 */
public final class ZGridActivity extends BaseActivity implements GridClickListener {

    @Override
    protected int getResourceLayoutId() {
        return R.layout.z_activity_grid;
    }

    @Override
    protected void afterInflation() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // get extra values
        int imgPlaceHolderResId = getIntent().getIntExtra(Constants.IntentPassingParams.IMG_PLACEHOLDER, -1);
        int spanCount = getIntent().getIntExtra(Constants.IntentPassingParams.COUNT, 2);

        GridImagesAdapter adapter = new GridImagesAdapter(this, imageURLs, imgPlaceHolderResId);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int pos) {
        ZGallery.with(this, imageURLs)
                .setToolbarTitleColor(ZColor.WHITE)
                .setToolbarColorResId(toolbarColorResId)
                .setSelectedImgPosition(pos)
                .setTitle(mToolbar.getTitle().toString())
                .show();
    }
}
