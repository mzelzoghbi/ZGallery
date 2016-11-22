package com.mzelzoghbi.zgallery;

import android.app.Activity;
import android.content.Intent;

import com.mzelzoghbi.zgallery.activities.ZGalleryActivity;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/11/16.
 */
public class ZGallery {
    private Activity mActivity;
    private ArrayList<String> imagesURLs;
    private String title;
    private int spanCount = 2;
    private int toolbarColor = -1;
    private int imgPlaceHolderResId = -1;
    private ZColor color;
    private int selectedImgPosition;
    private ZColor backgroundColor;

    private ZGallery() {
    }

    /**
     * @param activity   Refrence from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static ZGallery with(Activity activity, ArrayList<String> imagesURLs) {
        return new ZGallery(activity, imagesURLs);
    }


    private ZGallery(Activity activity, ArrayList<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    /**
     * Set toolbar title
     *
     * @param title
     * @return
     */
    public ZGallery setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Setting toolbar Color ResourceId
     *
     * @param colorResId
     * @return
     */
    public ZGallery setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Setting toolbar color
     *
     * @param color enum color may be black or white
     * @return
     */
    public ZGallery setToolbarTitleColor(ZColor color) {
        this.color = color;
        return this;
    }

    /**
     * Setting starting position
     *
     * @param selectedImgPosition
     * @return
     */
    public ZGallery setSelectedImgPosition(int selectedImgPosition) {
        this.selectedImgPosition = selectedImgPosition;
        return this;
    }

    public ZGallery setGalleryBackgroundColor(ZColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Start the gallery activity with builder settings
     */
    public void show() {
        Intent gridActivity = new Intent(mActivity, ZGalleryActivity.class);
        gridActivity.putExtra(Constants.IntentPassingParams.IMAGES, imagesURLs);
        gridActivity.putExtra(Constants.IntentPassingParams.TITLE, title);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        gridActivity.putExtra(Constants.IntentPassingParams.SELECTED_IMG_POS, selectedImgPosition);
        gridActivity.putExtra(Constants.IntentPassingParams.BG_COLOR, backgroundColor);
        mActivity.startActivity(gridActivity);
    }
}
