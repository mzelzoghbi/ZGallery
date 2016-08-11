package com.mzelzoghbi.zgallery;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/7/16.
 */
public class ZGrid {
    private final Activity mActivity;
    private final ArrayList<String> imagesURLs;
    private String title;
    private int spanCount = 2;
    private int toolbarColor = -1;
    private int imgPlaceHolderResId = -1;

    /**
     * @param activity   Refrence from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static ZGrid with(Activity activity, ArrayList<String> imagesURLs) {
        return new ZGrid(activity, imagesURLs);
    }


    private ZGrid(Activity activity, ArrayList<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    /**
     * Set toolbar title
     *
     * @param title
     * @return
     */
    public ZGrid setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set grid layout colums count (default: 2)
     *
     * @param count integer number for colum count
     * @return
     */
    public ZGrid setSpanCount(int count) {
        this.spanCount = count;
        return this;
    }

    /**
     * Setting toolbar Color ResourceId
     *
     * @param colorResId
     * @return
     */
    public ZGrid setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Set placeholder image for images in the grid
     * @param imgPlaceHolderResId
     * @return
     */
    public ZGrid setGridImgPlaceHolder(int imgPlaceHolderResId) {
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        return this;
    }

    /**
     * Start the grid activity with builder settings
     */
    public void show() {
        Intent gridActivity = new Intent(mActivity, ZGridActivity.class);
        gridActivity.putExtra(Constants.IntentPassingParams.IMAGES, imagesURLs);
        gridActivity.putExtra(Constants.IntentPassingParams.COUNT, spanCount);
        gridActivity.putExtra(Constants.IntentPassingParams.TITLE, title);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridActivity.putExtra(Constants.IntentPassingParams.IMG_PLACEHOLDER, imgPlaceHolderResId);
        mActivity.startActivity(gridActivity);
    }
}
