package com.devsprint.unplugged;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.health.connect.datatypes.AppInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

;import java.util.ArrayList;
import java.util.List;

/**
 * Created by enyason on 7/28/18.
 */

public class AppDrawerFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    TextView searchBox;
    ArrayList<AppItem> apps_list;

    ArrayList<AppItem> disp_list;






    public AppDrawerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apps_drawer,container,false);
        recyclerView = view.findViewById(R.id.app_list);
        searchBox = view.findViewById(R.id.searchBox);
        apps_list = new ArrayList<AppItem>();
        disp_list = new ArrayList<AppItem>();

        setUpApps(view.getContext());
        adapter = new AppListRecyclerAdapter(getContext(), disp_list);

        recyclerView = view.findViewById(R.id.app_list);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Log.d("com.devsprint.unplugged", "abcd " +apps_list.get(2).AppName);

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                filter(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });


        return view;
    }

    void filter(String text){
        disp_list.clear();
        for(AppItem d: apps_list){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.AppName.toLowerCase().contains(text.toLowerCase())){
                disp_list.add(d);
            }

            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    public void setUpApps(Context c) {
        PackageManager pm = c.getPackageManager();


        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        int j = 0;


        List<ResolveInfo> allApps = pm.queryIntentActivities(i, 0);
        for(ResolveInfo ri:allApps) {
            AppItem app = new AppItem();
            app.AppName = ri.loadLabel(pm).toString();
            app.AppId = ri.activityInfo.packageName.toString();
            apps_list.add(app);
            disp_list.add(app);
            j++;
        }
        Log.d("abcde", "xyz " + apps_list.size());



    }





}



