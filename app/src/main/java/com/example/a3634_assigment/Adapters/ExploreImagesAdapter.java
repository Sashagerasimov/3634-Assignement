package com.example.a3634_assigment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3634_assigment.Activities.ExploreImageActivity;
import com.example.a3634_assigment.Models.NasaImages.Item;
import com.example.a3634_assigment.R;

import java.util.ArrayList;

public class ExploreImagesAdapter extends RecyclerView.Adapter<ExploreImagesAdapter.ImageViewHolder> {
    public ArrayList<Item> images = new ArrayList<>();

    public void setData(ArrayList<Item> imagesToAdapt) {
        this.images = imagesToAdapt;

    }

    //standard viewHolder
    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public ImageView picture;
        public ImageViewHolder(View v) {
            super(v);
            view = v;
            picture = v.findViewById(R.id.image_explore);
        }
    }
    @NonNull
    @Override
    public ExploreImagesAdapter.ImageViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_image, parent, false);

        ExploreImagesAdapter.ImageViewHolder imageViewHolder = new ExploreImagesAdapter.ImageViewHolder(view);
        return imageViewHolder;
    }

    //onBindViewHolder uses intents to pass url and title for the relevant images
    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        final Item currentItem = images.get(position);
        Glide.with(holder.itemView.getContext()).load(currentItem.getLinks().get(0).getHref()).into(holder.picture);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent explicitIntent = new Intent(context, ExploreImageActivity.class);
                explicitIntent.putExtra("url", currentItem.getLinks().get(0).getHref());
                explicitIntent.putExtra("title", currentItem.getData().get(0).getTitle());
                context.startActivity(explicitIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return images.size();
    }
}
