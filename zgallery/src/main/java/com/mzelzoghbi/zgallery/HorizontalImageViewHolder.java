package com.mzelzoghbi.zgallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by mohamedzakaria on 8/7/16.
 */
public class HorizontalImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;

    public HorizontalImageViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.iv);
    }
}
