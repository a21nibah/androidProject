package com.example.androidproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder>
{
private ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CarViewHolder extends RecyclerView.ViewHolder
{
private TextView name;
private TextView company;
private TextView category;
    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
this.name=itemView.findViewById(R.id.name);
                this.category=itemView.findViewById(R.id.category);
                this.company=itemView.findViewById(R.id.company);
    }
}
}
