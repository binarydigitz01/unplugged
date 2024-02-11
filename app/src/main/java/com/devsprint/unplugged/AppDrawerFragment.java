package com.devsprint.unplugged;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.health.connect.datatypes.AppInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    ArrayList<AppItem> apps_list;


    public AppDrawerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apps_drawer,container,false);
        recyclerView = view.findViewById(R.id.app_list);
        apps_list = new ArrayList<AppItem>();
        setUpApps(view.getContext());
        adapter = new AppListRecyclerAdapter(getContext(), apps_list);

        recyclerView = view.findViewById(R.id.app_list);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Log.d("com.devsprint.unplugged", "abcd " +apps_list.get(2).AppName);


        return view;
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
            j++;
        }
        Log.d("abcde", "xyz " + apps_list.size());

    }





}



