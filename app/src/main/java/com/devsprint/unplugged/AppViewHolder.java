package com.devsprint.unplugged;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class AppViewHolder extends ViewHolder implements OnClickListener{

    public TextView appName;
    public String appID;
    public AppViewHolder(@NonNull View itemView) {
        super(itemView);
        appName = itemView.findViewById(R.id.appLabel);
        appName.setText("Hello");
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        Context context = v.getContext();
        Log.d("ab","1234");

        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(appID);
        context.startActivity(launchIntent);
        Toast.makeText(v.getContext(), appName.getText().toString(), Toast.LENGTH_LONG).show();

    }


}

