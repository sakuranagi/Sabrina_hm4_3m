package com.example.sabrina_hm4_3m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {

    private ArrayList<Continent> continentList;
    private OnItemClickListener onItemClickListener;

    public ContinentAdapter(ArrayList<Continent> continentList, OnItemClickListener onItemClickListener) {
        this.continentList = continentList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ContinentAdapter.ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentAdapter.ContinentViewHolder holder, int position) {
    holder.bind(continentList.get(position));
    }

    @Override
    public int getItemCount() {
        return continentList.size();
    }

    public class ContinentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView imgFlag;

        public ContinentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_continent_name);
            imgFlag = itemView.findViewById(R.id.img_flag);
        }

        public void bind(Continent continent){
            tvName.setText(continent.getName());
            Glide.with(imgFlag).load(continent.getFlag()).into(imgFlag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
