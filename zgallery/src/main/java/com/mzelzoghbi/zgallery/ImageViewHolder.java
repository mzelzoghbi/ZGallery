package com.mzelzoghbi.zgallery;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by mohamedzakaria on 8/7/16.
 *
 * Modified by mirjalal on 16/11/20.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;

    public ImageViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
