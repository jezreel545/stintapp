package com.example.stint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> userArrayList;

    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.items,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        User user = userArrayList.get(position);

        holder.fullname.setText(user.Fullname);;
        holder.useremail.setText(user.UserEmail);
        holder.timein.setText(user.TimeIn);
        holder.timeout.setText(user.TimeOut);

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView useremail,timein,timeout,fullname;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            useremail = itemView.findViewById(R.id.tvemail);
            timein = itemView.findViewById(R.id.timein_tv);
            timeout = itemView.findViewById(R.id.timeout_tv);
            fullname = itemView.findViewById(R.id.tvfullname);
        }
    }
}
