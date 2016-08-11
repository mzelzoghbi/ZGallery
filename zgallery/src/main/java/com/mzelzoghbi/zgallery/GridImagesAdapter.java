package com.mzelzoghbi.zgallery;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/7/16.
 */
public class GridImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    ArrayList<String> imageURLs;
    Activity mActivity;
    int imgPlaceHolderResId = -1;

    public GridImagesAdapter(Activity activity, ArrayList<String> imageURLs, int imgPlaceHolderResId) {
        this.imageURLs = imageURLs;
        this.mActivity = activity;
        this.imgPlaceHolderResId = imgPlaceHolderResId;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, null));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Glide.with(mActivity).load(imageURLs.get(position))
                .placeholder(imgPlaceHolderResId != -1 ? imgPlaceHolderResId : R.drawable.placeholder)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageURLs != null ? imageURLs.size() : 0;
    }
}
