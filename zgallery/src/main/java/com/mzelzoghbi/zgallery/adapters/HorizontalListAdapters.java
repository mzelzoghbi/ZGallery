package com.mzelzoghbi.zgallery.adapters;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mzelzoghbi.zgallery.HorizontalImageViewHolder;
import com.mzelzoghbi.zgallery.OnImgClick;
import com.mzelzoghbi.zgallery.R;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/12/16.
 */
public class HorizontalListAdapters extends RecyclerView.Adapter<HorizontalImageViewHolder> {
    ArrayList<String> images;
    AppCompatActivity activity;
    int selectedItem = -1;
    OnImgClick imgClick;

    public HorizontalListAdapters(AppCompatActivity activity, ArrayList<String> images, OnImgClick imgClick) {
        this.activity = activity;
        this.images = images;
        this.imgClick = imgClick;
    }

    @Override
    public HorizontalImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorizontalImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.z_item_image_horizontal, null));
    }

    @Override
    public void onBindViewHolder(HorizontalImageViewHolder holder, final int position) {
        Glide.with(activity).load(images.get(position)).into(holder.image);
        ColorMatrix matrix = new ColorMatrix();
        if (selectedItem != position) {
            matrix.setSaturation(0);

            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            holder.image.setColorFilter(filter);
            holder.image.setAlpha(0.5f);
        } else {
            matrix.setSaturation(1);

            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            holder.image.setColorFilter(filter);
            holder.image.setAlpha(1f);
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setSelectedItem(int position) {
        selectedItem = position;
        notifyDataSetChanged();
    }
}
