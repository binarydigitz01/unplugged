package com.devsprint.unplugged;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppListRecyclerAdapter extends RecyclerView.Adapter<AppViewHolder> {
    Context context;
    ArrayList<AppItem> app_list;

    public AppListRecyclerAdapter(Context context, ArrayList<AppItem> app_list){
        this.context = context;
         this.app_list = app_list;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("d", "1abcdefgh");

        return new AppViewHolder(LayoutInflater.from(context).inflate(R.layout.app_item,parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        holder.appName.setText(app_list.get(position).AppName);
        Log.d("d", "abcdefgh");
    }

    @Override
    public int getItemCount() {
        return app_list.size();
    }
}
