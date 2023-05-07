package com.example.myapplication.databaseAdapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dbHelper.DbHelper;
import com.example.myapplication.model.User;

import java.util.List;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {
    private Context context;
    private List<User> userList;


    public DbAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }


    @NonNull
    @Override
    public DbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dbuserlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DbAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.id.setText(Integer.toString(user.getId()));
        holder.userName.setText(user.getName());
        holder.userAddress.setText(user.getAddress());
        holder.userPhone.setText(user.getPhone());
        holder.dbDelete.setImageResource(R.drawable.delete);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView userName;
        public TextView userAddress;
        public TextView userPhone;
        public TextView id;
        public ImageView dbDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            id = itemView.findViewById(R.id.dbId);
            userName = itemView.findViewById(R.id.dbuserName);
            userAddress = itemView.findViewById(R.id.dbuserAddress);
            userPhone = itemView.findViewById(R.id.dbPhone);
            dbDelete = itemView.findViewById(R.id.dbDelete);



        }



        @Override
        public void onClick(View v) {



//            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            Log.d("dbPrashantClick", "clicked");
        }
    }


}
