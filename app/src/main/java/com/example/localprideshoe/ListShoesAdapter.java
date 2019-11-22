package com.example.localprideshoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListShoesAdapter extends RecyclerView.Adapter<ListShoesAdapter.ListViewHolder> {

    private Activity activity;
    private ArrayList <Shoes> listShoes;

    ListShoesAdapter(Activity activity, ArrayList<Shoes> list) {
        this.activity = activity;
        this.listShoes = list;
    }

    @NonNull
    @Override
    public ListShoesAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_shoes_adapter, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Shoes shoes =listShoes.get(position);
        Glide.with(holder.itemView.getContext())
                .load(shoes.getPhoto())
                .into(holder.BrandImage);
        holder.Name.setText(shoes.getName());

        holder.Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, BrandDetail.class);
                intent.putExtra(BrandDetail.EXTRA_SHOES, shoes);
                activity.startActivity(intent);
            }
        });

        holder.BrandImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, BrandDetail.class);
                intent.putExtra(BrandDetail.EXTRA_SHOES, shoes);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listShoes.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView BrandImage;
        TextView Name;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            BrandImage = itemView.findViewById(R.id.img_brand);
            Name = itemView.findViewById(R.id.shoes_name);
        }
    }
}
