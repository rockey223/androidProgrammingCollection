package com.example.myapplication.databaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import com.example.myapplication.R;
import com.example.myapplication.model.apiModel;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiViewHolder> {
    Context context;
    List<apiModel> users;

    public ApiAdapter(Context context, List<apiModel> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ApiViewHolder(LayoutInflater.from(context).inflate(R.layout.apilayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
holder.apiname.setText(users.get(position).getName());
holder.apiphone.setText(users.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
