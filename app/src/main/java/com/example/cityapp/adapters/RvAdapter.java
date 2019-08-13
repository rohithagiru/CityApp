package com.example.cityapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityapp.R;
import com.example.cityapp.data.City;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private LinkedList<City> cityArrayList;

    public RvAdapter(Context ctx, LinkedList<City> cities){

        inflater = LayoutInflater.from(ctx);
        this.cityArrayList = cities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.rv_row, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(cityArrayList.get(position).getImageUrl()).into(holder.iv);
        holder.name.setText(cityArrayList.get(position).getName());
        holder.country.setText(cityArrayList.get(position).getCountry());
        holder.city.setText(cityArrayList.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView country, name, city;
        ImageView iv;
        public MyViewHolder(View itemView) {
            super(itemView);

            country = (TextView) itemView.findViewById(R.id.country);
            name = (TextView) itemView.findViewById(R.id.name);
            city = (TextView) itemView.findViewById(R.id.city);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}