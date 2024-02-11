package com.devsprint.unplugged;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class AppViewHolder extends ViewHolder {

    public TextView appName;
    public AppViewHolder(@NonNull View itemView) {
        super(itemView);
        appName = itemView.findViewById(R.id.appLabel);
        appName.setText("Hello");
    }
}
