package com.dendickys.myasynctaskloaderexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private ArrayList<WeatherItems> mData = new ArrayList<>();

    public WeatherAdapter() {

    }

    public void setData (ArrayList<WeatherItems> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem (final WeatherItems item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData.clear();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_items, viewGroup, false);
        return new WeatherViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position) {
        weatherViewHolder.tv_nama_kota.setText(mData.get(position).getName());
        weatherViewHolder.tv_temperature.setText(mData.get(position).getTemperature());
        weatherViewHolder.tv_description.setText(mData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama_kota;
        TextView tv_temperature;
        TextView tv_description;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama_kota = itemView.findViewById(R.id.textKota);
            tv_temperature = itemView.findViewById(R.id.textTemp);
            tv_description = itemView.findViewById(R.id.textDesc);
        }
    }
}
