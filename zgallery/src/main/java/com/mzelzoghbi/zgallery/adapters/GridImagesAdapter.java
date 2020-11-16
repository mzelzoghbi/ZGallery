package com.mzelzoghbi.zgallery.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mzelzoghbi.zgallery.ImageViewHolder;
import com.mzelzoghbi.zgallery.R;
import com.mzelzoghbi.zgallery.adapters.listeners.GridClickListener;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/7/16.
 *
 * Modified by mirjalal on 16/11/20.
 */
public class GridImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private final ArrayList<String> imageURLs;
    private final Activity mActivity;
    private int imgPlaceHolderResId = -1;
    private final GridClickListener clickListener;

    public GridImagesAdapter(Activity activity, ArrayList<String> imageURLs, int imgPlaceHolderResId) {
        this.imageURLs = imageURLs;
        this.mActivity = activity;
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        this.clickListener = (GridClickListener) activity;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.z_item_image, null));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
        RequestOptions requestOptions = new RequestOptions().placeholder(imgPlaceHolderResId != -1 ? imgPlaceHolderResId : R.drawable.placeholder);
        Glide.with(mActivity).load(imageURLs.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageURLs != null ? imageURLs.size() : 0;
    }
}
