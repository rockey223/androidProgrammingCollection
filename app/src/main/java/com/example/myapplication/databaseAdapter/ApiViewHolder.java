package com.example.myapplication.databaseAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ApiViewHolder extends RecyclerView.ViewHolder {

    TextView apiname,apiphone;

    public ApiViewHolder(View userview) {
        super(userview);
        apiname = userview.findViewById(R.id.apiname);
        apiphone = userview.findViewById(R.id.apiphone);
    }
}
